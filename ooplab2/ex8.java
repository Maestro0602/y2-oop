import java.util.ArrayList;
import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Use ArrayList to store the 5 values
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] labels = {"A", "B", "C", "D", "E"};
        
        // Input 5 values
        for (int i = 0; i < 5; i++) {
            System.out.print("Input value of " + labels[i] + ": ");
            numbers.add(sc.nextInt());
        }
        
        int minimum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < minimum) {
                minimum = numbers.get(i);
            }
        }
        
        System.out.println("The smallest number among A, B, C, D, and E is: " + minimum);
        
        sc.close();
    }
}
