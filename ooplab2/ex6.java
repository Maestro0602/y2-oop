import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input a number to check whether it is a prime number: ");
        int n = sc.nextInt();
        
        boolean isPrime = true;
        int divisor = 0;
        
        // Check if number is less than or equal to 1
        if (n <= 1) {
            isPrime = false;
        } else {
            // Check for divisors from 2 to sqrt(n)
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    divisor = i;
                    break;
                }
            }
        }
        
        // Display result
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            if (divisor > 0) {
                System.out.println(n + " is not a prime number, because it is divisible by " + divisor + ".");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }
        
        sc.close();
    }
}

