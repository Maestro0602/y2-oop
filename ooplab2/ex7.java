import java.util.ArrayList;
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input a sentence: ");
        String sentence = sc.nextLine();
        
        // Use ArrayList to store character counts
        ArrayList<Integer> counts = new ArrayList<>();
        
        int vowelCount = 0;
        int consonantCount = 0;
        int spaceCount = 0;
        
        // Convert to lowercase for easier vowel checking
        String lowerSentence = sentence.toLowerCase();
        
        for (int i = 0; i < lowerSentence.length(); i++) {
            char c = lowerSentence.charAt(i);
            
            if (c == ' ') {
                spaceCount++;
            } else if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        
        // Store counts in ArrayList
        counts.add(vowelCount);
        counts.add(consonantCount);
        counts.add(spaceCount);
        
        System.out.println("Count of vowel is: " + counts.get(0));
        System.out.println("Count of consonant is: " + counts.get(1));
        System.out.println("Count of space is: " + counts.get(2));
        
        sc.close();
    }
}
