import java.util.ArrayList;
import java.util.Scanner;

class student {
    String name;
    String id;
    int age;

    public student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<student> students = new ArrayList<>();

        while (true) {
            System.out.println("Enter Student ID: ");
            String id = sc.next();

            sc.nextLine(); // clear buffer

            System.out.println("Enter Name: ");
            String name = sc.nextLine();

            System.out.println("Enter Age: ");
            int age = sc.nextInt();

            students.add(new student(id, name, age));

            System.out.println("Do you want to add more (y/n)?: ");
            char choice = sc.next().charAt(0);

            if (choice == 'n' || choice == 'N') {
                break;
            }
        }

        // Display table
        System.out.println("=========================================");
        System.out.printf("| %-3s | %-5s | %-10s | %-3s |\n", "No", "ID", "Name", "Age");
        System.out.println("=========================================");

        int index = 1;
        for (student s : students) {
            System.out.printf("| %-3d | %-5s | %-10s | %-3d |\n",
                    index++, s.id, s.name, s.age);
        }

        System.out.println("=========================================");

        sc.close();
    }
}