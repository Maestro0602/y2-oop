import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program for converting money in Riels to Dollars.");
        System.out.print("Please input conversion rate of 1 dollar in Riels: ");
        int ex_rate = sc.nextInt();

        System.out.print("Please input money to exchange in Riels: ");
        int money = sc.nextInt();

        double total = (double) money / ex_rate; 

        sc.close();

        System.out.println("Converted amount in Dollars: " + total);
    }
}