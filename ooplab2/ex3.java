import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize questions using ArrayList
        ArrayList<String> questions = new ArrayList<>();
        questions.add("Feeling feverish and/or having chills?");
        questions.add("Has there been any use of fever reducing medication within the last 24 hours not due to another health condition?");
        questions.add("A new cough that is not due to another health condition?");
        questions.add("New chills that are not due to another health condition?");
        questions.add("A new sore throat that is not due to another health condition?");
        questions.add("A new loss of taste or smell?");
        questions.add("Have you had a positive test for the virus that causes COVID-19 disease within the past 10 days?");
        questions.add("In the past 14 days, have you had close contact (within about 6 feet for 15 minutes or more) with someone with suspected or confirmed COVID-19?");
        
        // Initialize answers using ArrayList
        ArrayList<String> answers = new ArrayList<>();
        
        System.out.println("==== Covid-19 Screen Health ====");
        for (int i = 0; i < questions.size(); i++) {
            System.out.print("Q" + (i + 1) + ". " + questions.get(i) + " ");
            String answer = sc.nextLine().trim().toUpperCase();
            answers.add(answer);
        }
        
        // Display results
        System.out.println("======================================================");
        System.out.println("| Questions                | Answers                |");
        System.out.println("======================================================");
        
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("| Q%-23d | %-22s |%n", (i + 1), answers.get(i));
            System.out.println("------------------------------------------------------");
        }
        
        sc.close();
    }
}
