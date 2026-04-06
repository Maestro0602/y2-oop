import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b:");
        double b = input.nextDouble();
        System.out.print("Enter C:");
        double c = input.nextDouble();
        
        double discriminant = b * b - 4 * a * c;
        
        if(discriminant < 0) {
            System.out.println("No real solutions");
        }
        else {
            double ans1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double ans2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(ans1 + " is answer 1");
            System.out.println(ans2 + " is answer 2");
        }
        input.close();

    }
}
