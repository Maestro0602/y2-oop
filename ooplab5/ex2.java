import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Ex2Student {
    private final int id;
    private final String name;
    private final int age;

    public Ex2Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Ex2StudentManager {
    private final List<Ex2Student> students;

    public Ex2StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudents(Scanner sc) {
        int count = 1;

        while (true) {
            System.out.println("Student #" + count + ":");

            int id = readInt(sc, "Id: ");

            System.out.print("Name: ");
            String name = sc.nextLine().trim();

            int age = readInt(sc, "Age: ");

            students.add(new Ex2Student(id, name, age));
            count++;

            System.out.print("Do you want to add more (y/n)?: ");
            String answer = sc.nextLine().trim().toLowerCase();
            System.out.println();

            if (!answer.equals("y")) {
                break;
            }
        }
    }

    public void deleteMultipleStudents(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("No students to delete.\n");
            return;
        }

        displayStudents();

        List<Integer> idsToDelete = new ArrayList<>();
        int count = 1;

        while (true) {
            int id = readInt(sc, "Input student #" + count + " ID: ");
            idsToDelete.add(id);

            System.out.print("Do you want to delete more (y/n)?: ");
            String answer = sc.nextLine().trim().toLowerCase();

            if (!answer.equals("y")) {
                break;
            }

            count++;
        }

        System.out.println();

        for (int id : idsToDelete) {
            boolean removed = removeById(id);
            if (removed) {
                System.out.println("Student with ID " + id + " deleted");
            } else {
                System.out.println("Student with ID " + id + " not found!");
            }
        }

        System.out.println();
    }

    private boolean removeById(int id) {
        Iterator<Ex2Student> it = students.iterator();

        while (it.hasNext()) {
            Ex2Student student = it.next();
            if (student.getId() == id) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the table.\n");
            return;
        }

        String line = "====================================================";
        System.out.println(line);
        System.out.printf("| %-4s | %-10s | %-20s | %-4s |%n", "No", "ID", "Name", "Age");
        System.out.println(line);

        for (int i = 0; i < students.size(); i++) {
            Ex2Student s = students.get(i);
            System.out.printf("| %-4d | %-10d | %-20s | %-4d |%n", i + 1, s.getId(), s.getName(), s.getAge());
        }

        System.out.println(line);
        System.out.println();
    }

    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }
}

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex2StudentManager manager = new Ex2StudentManager();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1.  Add new students");
            System.out.println("2.  Delete multiple students");
            System.out.println("3.  Quit");
            System.out.print("Choose an opt: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    manager.addStudents(sc);
                    break;
                case "2":
                    manager.deleteMultipleStudents(sc);
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
