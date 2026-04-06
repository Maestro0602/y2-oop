import java.util.ArrayList;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        System.err.println("How many number to input");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
          ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0;i<n;i++){
            System.err.println("value#"+i+1+ ": ");
             numbers.add(input.nextInt());
        }
        int sum =0;
         int max = numbers.get(0);
        int min = numbers.get(0);
          for (int num : numbers) {
            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        double average = (double) sum / n;

        // Output
        System.out.println("\nMax: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
        System.out.println("Sum: " + sum);

        input.close();
    }
}
