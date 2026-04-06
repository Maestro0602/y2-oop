import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String sex;
    protected String email;

    public Person(String firstName, String lastName, String sex, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
    }

    public abstract String toFileFormat();

    public abstract void display(int index);
}

class Teacher extends Person {
    private final String subject;
    private final double salary;

    public Teacher(String firstName, String lastName, String sex, String email, String subject, double salary) {
        super(firstName, lastName, sex, email);
        this.subject = subject;
        this.salary = salary;
    }

    @Override
    public String toFileFormat() {
        return firstName + "|" + lastName + "|" + sex + "|" + email + "|" + subject + "|" + salary;
    }

    @Override
    public void display(int index) {
        System.out.println(index + ". [" + firstName + " " + lastName + "][" + sex + "][" + email + "][" + subject + "][" + salary + "]");
    }

    public static Teacher fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        return new Teacher(parts[0], parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
    }
}

class Student extends Person {
    private final int year;
    private final String major;

    public Student(String firstName, String lastName, String sex, String email, int year, String major) {
        super(firstName, lastName, sex, email);
        this.year = year;
        this.major = major;
    }

    @Override
    public String toFileFormat() {
        return firstName + "|" + lastName + "|" + sex + "|" + email + "|" + year + "|" + major;
    }

    @Override
    public void display(int index) {
        System.out.println(index + ". [" + firstName + " " + lastName + "][" + sex + "][" + email + "][" + year + "][" + major + "]");
    }

    public static Student fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        return new Student(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]);
    }
}

class SecurityGuard extends Person {
    private final String job;

    public SecurityGuard(String firstName, String lastName, String sex, String email, String job) {
        super(firstName, lastName, sex, email);
        this.job = job;
    }

    @Override
    public String toFileFormat() {
        return firstName + "|" + lastName + "|" + sex + "|" + email + "|" + job;
    }

    @Override
    public void display(int index) {
        System.out.println(index + ". [" + firstName + " " + lastName + "][" + sex + "][" + email + "][" + job + "]");
    }

    public static SecurityGuard fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        return new SecurityGuard(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}

class HRManager {
    private static final String TEACHER_FILE = "teacher.txt";
    private static final String STUDENT_FILE = "student.txt";
    private static final String SECURITYGUARD_FILE = "securityguard.txt";

    private final List<Teacher> teachers;
    private final List<Student> students;
    private final List<SecurityGuard> securityGuards;

    public HRManager() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.securityGuards = new ArrayList<>();
        loadAllFromFiles();
    }

    private void loadAllFromFiles() {
        loadTeachers();
        loadStudents();
        loadSecurityGuards();
    }

    private void loadTeachers() {
        File file = new File(TEACHER_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                teachers.add(Teacher.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading teacher file: " + e.getMessage());
        }
    }

    private void loadStudents() {
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading student file: " + e.getMessage());
        }
    }

    private void loadSecurityGuards() {
        File file = new File(SECURITYGUARD_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                securityGuards.add(SecurityGuard.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading security guard file: " + e.getMessage());
        }
    }

    private void saveAllToFiles() {
        saveTeachers();
        saveStudents();
        saveSecurityGuards();
    }

    private void saveTeachers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEACHER_FILE))) {
            for (Teacher teacher : teachers) {
                writer.write(teacher.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing teacher file: " + e.getMessage());
        }
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE))) {
            for (Student student : students) {
                writer.write(student.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing student file: " + e.getMessage());
        }
    }

    private void saveSecurityGuards() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SECURITYGUARD_FILE))) {
            for (SecurityGuard guard : securityGuards) {
                writer.write(guard.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing security guard file: " + e.getMessage());
        }
    }

    public void viewAll() {
        System.out.println("==== Teacher ====");
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            for (int i = 0; i < teachers.size(); i++) {
                teachers.get(i).display(i + 1);
            }
        }

        System.out.println("\n=========== Student ===========");
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                students.get(i).display(i + 1);
            }
        }

        System.out.println("\n=========== Security guard ===========");
        if (securityGuards.isEmpty()) {
            System.out.println("No security guards found.");
        } else {
            for (int i = 0; i < securityGuards.size(); i++) {
                securityGuards.get(i).display(i + 1);
            }
        }

        System.out.println();
    }

    public void addNewResource(Scanner sc) {
        System.out.println("==== Add new resource ====");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Security guard");
        System.out.print("Choose an opt: ");

        String choice = sc.nextLine().trim();
        System.out.println();

        switch (choice) {
            case "1":
                addTeacher(sc);
                break;
            case "2":
                addStudent(sc);
                break;
            case "3":
                addSecurityGuard(sc);
                break;
            default:
                System.out.println("Invalid option.\n");
                break;
        }
    }

    private void addTeacher(Scanner sc) {
        System.out.print("First Name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Sex: ");
        String sex = sc.nextLine().trim();

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Subject: ");
        String subject = sc.nextLine().trim();

        System.out.print("Salary: ");
        double salary = readDouble(sc);

        teachers.add(new Teacher(firstName, lastName, sex, email, subject, salary));
        System.out.println("Teacher added successfully.\n");
        saveAllToFiles();
    }

    private void addStudent(Scanner sc) {
        System.out.print("First Name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Sex: ");
        String sex = sc.nextLine().trim();

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Year: ");
        int year = readInt(sc);

        System.out.print("Major: ");
        String major = sc.nextLine().trim();

        students.add(new Student(firstName, lastName, sex, email, year, major));
        System.out.println("Student added successfully.\n");
        saveAllToFiles();
    }

    private void addSecurityGuard(Scanner sc) {
        System.out.print("First Name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Sex: ");
        String sex = sc.nextLine().trim();

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Job: ");
        String job = sc.nextLine().trim();

        securityGuards.add(new SecurityGuard(firstName, lastName, sex, email, job));
        System.out.println("Security guard added successfully.\n");
        saveAllToFiles();
    }

    private int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please input a valid number: ");
            }
        }
    }

    private double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please input a valid number: ");
            }
        }
    }
}

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HRManager manager = new HRManager();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1.  View all");
            System.out.println("2.  Add new");
            System.out.println("3.  Quit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    manager.viewAll();
                    break;
                case "2":
                    manager.addNewResource(sc);
                    break;
                case "3":
                    System.out.println("BYE BYE!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1-3.\n");
                    break;
            }
        }
    }
}
