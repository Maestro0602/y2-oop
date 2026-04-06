import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public void setValues(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
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

public class ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;
        
        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Create a student");
            System.out.println("2. List students");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Student #" + (students.size() + 1) + ":\n");
                    System.out.print("Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    
                    Student student = new Student(id, name, age);
                    students.add(student);
                    System.out.println("A student is added to the list");
                    break;
                    
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students in the list");
                    } else {
                        System.out.println("\n" + "=".repeat(55));
                        System.out.printf("| %-3s | %-5s | %-15s | %-5s |\n", "No", "ID", "Name", "Age");
                        System.out.println("=".repeat(55));
                        for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);
                            System.out.printf("| %-3d | %-5d | %-15s | %-5d |\n", 
                                i + 1, s.getId(), s.getName(), s.getAge());
                        }
                        System.out.println("=".repeat(55));
                    }
                    break;
                    
                case 3:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
