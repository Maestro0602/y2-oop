package lab6;
import java.util.Scanner;

class Math2 {

    // SUM
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    int sum(int[] arr) {

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }

    // MULTIPLY
    int multiply(int a, int b) {
        return a * b;
    }

    int multiply(int a, int b, int c) {
        return a * b * c;
    }

    int multiply(int[] arr) {

        int total = 1;

        for (int i = 0; i < arr.length; i++) {
            total *= arr[i];
        }

        return total;
    }

    // MAX
    int max(int a, int b) {

        if (a > b) {
            return a;
        }

        return b;
    }

    int max(int a, int b, int c) {

        int largest = a;

        if (b > largest) {
            largest = b;
        }

        if (c > largest) {
            largest = c;
        }

        return largest;
    }

    int max(int[] arr) {

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    // MIN
    int min(int a, int b) {

        if (a < b) {
            return a;
        }

        return b;
    }

    int min(int a, int b, int c) {

        int smallest = a;

        if (b < smallest) {
            smallest = b;
        }

        if (c < smallest) {
            smallest = c;
        }

        return smallest;
    }

    int min(int[] arr) {

        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    // AVERAGE
    double average(int a, int b) {
        return (a + b) / 2.0;
    }

    double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    double average(int[] arr) {

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return (double) total / arr.length;
    }
}

public class ex2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Math2 math = new Math2();

        int choice;

        do {

            System.out.println("==== Menu ====");
            System.out.println("1. Sum of two values");
            System.out.println("2. Sum of three values");
            System.out.println("3. Sum of many values");
            System.out.println("4. Multiply of two values");
            System.out.println("5. Multiply of three values");
            System.out.println("6. Multiply of many values");
            System.out.println("7. Max of two values");
            System.out.println("8. Max of three values");
            System.out.println("9. Max of many values");
            System.out.println("10. Min of two values");
            System.out.println("11. Min of three values");
            System.out.println("12. Min of many values");
            System.out.println("13. Average of two values");
            System.out.println("14. Average of three values");
            System.out.println("15. Average of many values");
            System.out.println("16. Quit");

            System.out.print("Choose option: ");
            choice = input.nextInt();

            switch (choice) {

                case 1: {

                    int a, b;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.println("Result: " + math.sum(a, b));
                    break;
                }

                case 2: {

                    int a, b, c;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.print("Enter third value: ");
                    c = input.nextInt();

                    System.out.println("Result: " + math.sum(a, b, c));
                    break;
                }

                case 3: {

                    int size;

                    System.out.print("How many values: ");
                    size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Result: " + math.sum(arr));
                    break;
                }

                case 4: {

                    int a, b;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.println("Result: " + math.multiply(a, b));
                    break;
                }

                case 5: {

                    int a, b, c;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.print("Enter third value: ");
                    c = input.nextInt();

                    System.out.println("Result: " + math.multiply(a, b, c));
                    break;
                }

                case 6: {

                    int size;

                    System.out.print("How many values: ");
                    size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Result: " + math.multiply(arr));
                    break;
                }

                case 7: {

                    int a, b;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.println("Result: " + math.max(a, b));
                    break;
                }

                case 8: {

                    int a, b, c;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.print("Enter third value: ");
                    c = input.nextInt();

                    System.out.println("Result: " + math.max(a, b, c));
                    break;
                }

                case 9: {

                    int size;

                    System.out.print("How many values: ");
                    size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Result: " + math.max(arr));
                    break;
                }

                case 10: {

                    int a, b;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.println("Result: " + math.min(a, b));
                    break;
                }

                case 11: {

                    int a, b, c;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.print("Enter third value: ");
                    c = input.nextInt();

                    System.out.println("Result: " + math.min(a, b, c));
                    break;
                }

                case 12: {

                    int size;

                    System.out.print("How many values: ");
                    size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Result: " + math.min(arr));
                    break;
                }

                case 13: {

                    int a, b;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.println("Result: " + math.average(a, b));
                    break;
                }

                case 14: {

                    int a, b, c;

                    System.out.print("Enter first value: ");
                    a = input.nextInt();

                    System.out.print("Enter second value: ");
                    b = input.nextInt();

                    System.out.print("Enter third value: ");
                    c = input.nextInt();

                    System.out.println("Result: " + math.average(a, b, c));
                    break;
                }

                case 15: {

                    int size;

                    System.out.print("How many values: ");
                    size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Result: " + math.average(arr));
                    break;
                }

                case 16:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

            System.out.println();

        } while (choice != 16);

        input.close();
    }
}