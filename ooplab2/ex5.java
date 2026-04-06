import java.util.Scanner;
public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for calculating equation 1/x = 1/y + 1/z to find value of x");
        System.out.print("Value of y: ");
        double y = sc.nextDouble();
        System.out.print("Value of Z: ");
        double z = sc.nextDouble();
        double x = (y * z) / (y + z);
        System.out.printf("%.7f", x);
    }
}
