import java.util.Scanner;

class InputUtils {
    static Scanner scanner = new Scanner(System.in);
    
    public static int getInteger(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
    
    public static float getFloat(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            try {
                return Float.parseFloat(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a float number.");
            }
        }
    }
    
    public static double getDouble(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double number.");
            }
        }
    }
    
    public static String getString(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            if (!line.isEmpty()) {
                return line;
            }
            
            System.out.println("Invalid input. Please enter a non-empty string.");
        }
    }
    
    public static char getGender(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            if (line.length() >= 1) {
                char c = Character.toUpperCase(line.charAt(0));
                if (c == 'M' || c == 'F') {
                    return c;
                }
            }
            
            System.out.println("Invalid input. Please enter M or F.");
        }
    }
    
    public static char getChar(String comment) {
        while (true) {
            System.out.print(comment);
            String line = scanner.nextLine();
            
            if (line.length() >= 1) {
                return line.charAt(0);
            }
            
            System.out.println("Invalid input. Please enter exactly one character.");
        }
    }
    
    public static int getOption(String comment, int maxOption) {
        if (maxOption < 0) {
            return 0;
        }
        
        while (true) {
            int option = getInteger(comment);
            
            if (option > 0 && option <= maxOption) {
                return option;
            }
            
            System.out.println("Invalid option. Please enter a number from 0 to " + maxOption + ".");
        }
    }
}

class Book {
    int id;
    String title;
    String author;
    int year;
    double price;
    
    public Book(int id, String title, String author, int year, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    
    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + 
                         ", Year: " + year + ", Price: $" + price);
    }
}

public class ex11 {
    public static void main(String[] args) {
        // Create Book objects
        Book b1 = new Book(1, "Java Basics", "John", 2020, 25.5);
        Book b2 = new Book(2, "Data Structures", "Alice", 2021, 30.0);
        Book b3 = new Book(3, "Algorithms", "Bob", 2019, 28.0);
 
        Book[] bookArr = new Book[3];
        bookArr[0] = b1;
        bookArr[1] = b2;
        bookArr[2] = b3;
        
        System.out.println("=== Book List ===");
        for (int i = 0; i < bookArr.length; i++) {
            System.out.print("Book " + (i + 1) + ": ");
            bookArr[i].display();
        }
    }
}
