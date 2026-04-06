import java.util.Scanner;

class specac {
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial not defined for negative numbers");
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static double rectangleSurface(double width, double height) {
        return width * height;
    }
    
    public static double circleSurface(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static double max(double a, double b, double c, double d, double e) {
        double maxVal = a;
        if (b > maxVal) maxVal = b;
        if (c > maxVal) maxVal = c;
        if (d > maxVal) maxVal = d;
        if (e > maxVal) maxVal = e;
        return maxVal;
    }
    
    public static double min(double a, double b, double c, double d, double e) {
        double minVal = a;
        if (b < minVal) minVal = b;
        if (c < minVal) minVal = c;
        if (d < minVal) minVal = d;
        if (e < minVal) minVal = e;
        return minVal;
    }
}

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose 1 method:");
        System.out.println("1. factorial");
        System.out.println("2. rectangleSurface");
        System.out.println("3. circleSurface");
        System.out.println("4. max (5 numbers)");
        System.out.println("5. min (5 numbers)");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Enter number: ");
                int n = sc.nextInt();
                long factResult = specac.factorial(n);
                System.out.println("Factorial: " + factResult);
                break;
            case 2:
                System.out.print("Enter width: ");
                double width = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                double rectArea = specac.rectangleSurface(width, height);
                System.out.println("Rectangle Surface: " + rectArea);
                break;
            case 3:
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                double circleArea = specac.circleSurface(radius);
                System.out.println("Circle Surface: " + circleArea);
                break;
            case 4:
                System.out.println("Enter 5 numbers:");
                System.out.print("A: ");
                double a = sc.nextDouble();
                System.out.print("B: ");
                double b = sc.nextDouble();
                System.out.print("C: ");
                double c = sc.nextDouble();
                System.out.print("D: ");
                double d = sc.nextDouble();
                System.out.print("E: ");
                double e = sc.nextDouble();
                double maxVal = specac.max(a, b, c, d, e);
                System.out.println("Maximum: " + maxVal);
                break;
            case 5:
                System.out.println("Enter 5 numbers:");
                System.out.print("A: ");
                a = sc.nextDouble();
                System.out.print("B: ");
                b = sc.nextDouble();
                System.out.print("C: ");
                c = sc.nextDouble();
                System.out.print("D: ");
                d = sc.nextDouble();
                System.out.print("E: ");
                e = sc.nextDouble();
                double minVal = specac.min(a, b, c, d, e);
                System.out.println("Minimum: " + minVal);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
