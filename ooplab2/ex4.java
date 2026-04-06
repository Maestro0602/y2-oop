import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input number of seconds: ");
        int totalSeconds = sc.nextInt();
        
        // Calculate hours, minutes, and seconds
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        // Format and display the result
        System.out.printf("Time corresponding to %d seconds is:: %02d:%02d:%02d%n", 
                          totalSeconds, hours, minutes, seconds);
        
        sc.close();
    }
}
