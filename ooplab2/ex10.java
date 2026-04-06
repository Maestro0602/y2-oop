import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueMenu = true;
        
        while (continueMenu) {
            System.out.println("=== Math Menu ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Quit");
            System.out.print("Please choose an option: ");
            
            int choice = sc.nextInt();
            
            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("Please input value A: ");
                double a = sc.nextDouble();
                System.out.print("Please input value B: ");
                double b = sc.nextDouble();
                
                double result = 0;
                String operation = "";
                
                switch (choice) {
                    case 1:
                        result = a + b;
                        operation = "Addition (+)";
                        break;
                    case 2:
                        result = a - b;
                        operation = "Subtraction (-)";
                        break;
                    case 3:
                        result = a * b;
                        operation = "Multiplication (*)";
                        break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Error: Cannot divide by zero!");
                            continue;
                        }
                        result = a / b;
                        operation = "Division (/)";
                        break;
                }
                
                System.out.println("=== " + operation + " ===");
                System.out.println("Result: " + result);
            } else {
                System.out.println("Please choose an option again.");
            }
            
            System.out.print("Do you want to continue? If no go to Menu. Input your answer (y/n): ");
            String answer = sc.next();
            
            if (answer.equalsIgnoreCase("n")) {
                continueMenu = false;
            }
            
            System.out.println();
        }
        
        sc.close();
    }
}
