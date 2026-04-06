import java.util.ArrayList;
import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Input value in Array at index: 0");
        numbers.add(sc.nextInt());
        
        int index = 1;
        while (true) {
            System.out.print("Do you want to add more (y/n): ");
            String response = sc.next();
            
            if (response.equalsIgnoreCase("n")) {
                break;
            }
            
            System.out.println("Input value in Array at index: " + index);
            numbers.add(sc.nextInt());
            index++;
        }
        
        // Find maximum value
        int maximum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > maximum) {
                maximum = numbers.get(i);
            }
        }
        
        System.out.println("The biggest number among in Array is: " + maximum);
        
        sc.close();
    }
}
