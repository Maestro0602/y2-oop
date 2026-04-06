import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;

    Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

class StudentManager {
    private Scanner sc;
    private List<Student> students = new ArrayList<>();

    StudentManager(Scanner sc) {
        this.sc = sc;
    }

    private void addStudent(String id, String name, int age) {
        students.add(new Student(id, name, age));
    }

    void collectStudents() {
        int number = 1;
        while (true) {
            System.out.println("Student #" + number);

            System.out.print("ID: ");
            String id = sc.next();

            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            addStudent(id, name, age);

            System.out.print("Do you want to add more (y/n)?: ");
            String choice = sc.next().toLowerCase();
            if (choice.equals("n")) {
                break;
            }

            number++;
            System.out.println();
        }
    }

    void displayStudents() {
        System.out.println("=".repeat(39));
        System.out.println("| No  | ID   | Name          | Age |");
        System.out.println("=".repeat(39));
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf("| %-3d | %-4s | %-13s | %-3d |%n", i + 1, student.getId(), student.getName(), student.getAge());
        }
        System.out.println("=".repeat(39));
    }


}

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager(sc);

        manager.collectStudents();
        manager.displayStudents();
    }
}
