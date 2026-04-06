import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class MyDate {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public void getCurrentDateTime() {
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current datetime is: " + current.format(DATETIME_FORMATTER));
    }

    public void calculateDaysBtwDates(String d1, String d2) {
        LocalDate date1 = LocalDate.parse(d1, DATE_FORMATTER);
        LocalDate date2 = LocalDate.parse(d2, DATE_FORMATTER);
        long daysBetween = Math.abs(ChronoUnit.DAYS.between(date1, date2));
        System.out.println("Difference between two dates is: " + daysBetween + " days");
    }

    public void findDay(String input) {
        LocalDate date = LocalDate.parse(input, DATE_FORMATTER);
        String day = date.getDayOfWeek().toString();
        day = day.substring(0, 1) + day.substring(1).toLowerCase();
        System.out.println("The day is: " + day);
    }
}

public class ex1 {
    public static void main(String[] args) {
        MyDate d = new MyDate();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==== Menu ===");
            System.out.println("1.  Current date and time");
            System.out.println("2.  Calculate days btw two dates");
            System.out.println("3.  Find the day of the week");
            System.out.println("4.  Quit");
            System.out.print("Choose an opt: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    d.getCurrentDateTime();
                    break;
                case "2":
                    System.out.print("First date (dd/mm/yyyy): ");
                    String firstDate = sc.nextLine().trim();
                    System.out.print("Second date (dd/mm/yyyy): ");
                    String secondDate = sc.nextLine().trim();
                    d.calculateDaysBtwDates(firstDate, secondDate);
                    break;
                case "3":
                    System.out.print("Input a date: ");
                    String inputDate = sc.nextLine().trim();
                    d.findDay(inputDate);
                    break;
                case "4":
                    System.out.println("BYE BYE!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
                    break;
            }

            System.out.println();
        }
    }
}
