import java.util.Scanner;

class cac {
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }
    
    public static double min(double a, double b) {
        return a < b ? a : b;
    }
    
    public static double max(double a, double b) {
        return a > b ? a : b;
    }
}

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose 1 method:");
        System.out.println("1. add");
        System.out.println("2. subtract");
        System.out.println("3. multiply");
        System.out.println("4. divide");
        System.out.println("5. min");
        System.out.println("6. max");
        System.out.print("Enter choice: ");
        int ans = sc.nextInt();
        
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        
        double result = 0;
        switch (ans) {
            case 1:
                result = cac.add(a, b);
                System.out.println("Result: " + result);
                break;
            case 2:
                result = cac.subtract(a, b);
                System.out.println("Result: " + result);
                break;
            case 3:
                result = cac.multiply(a, b);
                System.out.println("Result: " + result);
                break;
            case 4:
                result = cac.divide(a, b);
                System.out.println("Result: " + result);
                break;
            case 5:
                result = cac.min(a, b);
                System.out.println("Result: " + result);
                break;
            case 6:
                result = cac.max(a, b);
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}