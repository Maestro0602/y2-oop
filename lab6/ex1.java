package lab6;
import java.util.Scanner;

abstract class AbstractMath {

    int reverseNumber(int num) {
        return 0;
    }

    int roundedNumber(double num) {
        return 0;
    }

    int countDistinct(int[] values) {
        return 0;
    }

    int decimalToBinary(int decimal) {
        return 0;
    }
}

class Math1 extends AbstractMath {

    @Override
    int reverseNumber(int num) {
        int reverse = 0;

        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return reverse;
    }

    @Override
    int roundedNumber(double num) {
        int integerPart = (int) num;
        double decimalPart = num - integerPart;

        if (decimalPart >= 0.5) {
            return integerPart + 1;
        }

        return integerPart;
    }

    @Override
    int countDistinct(int[] values) {
        int distinct = 0;

        for (int i = 0; i < values.length; i++) {

            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (values[i] == values[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                distinct++;
            }
        }

        return distinct;
    }

    @Override
    int decimalToBinary(int decimal) {

        int binary = 0;
        int place = 1;

        while (decimal > 0) {

            int remainder = decimal % 2;

            binary = binary + (remainder * place);

            place = place * 10;

            decimal = decimal / 2;
        }

        return binary;
    }
}

public class ex1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Math1 math = new Math1();

        int choice;

        do {

            System.out.println("==== Menu ====");
            System.out.println("1. Reverse a number");
            System.out.println("2. Rounded number");
            System.out.println("3. Count distinct number");
            System.out.println("4. Decimal to Binary");
            System.out.println("5. Quit");

            System.out.print("Choose an opt: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n... Reverse a number ...");

                    System.out.print("Input number: ");
                    int number = input.nextInt();

                    System.out.println("Output is: "
                            + math.reverseNumber(number));

                    break;

                case 2:

                    System.out.println("\n... Rounded number ...");

                    System.out.print("Input decimal number: ");
                    double decimal = input.nextDouble();

                    System.out.println("Output is: "
                            + math.roundedNumber(decimal));

                    break;

                case 3:

                    System.out.println("\n... Count distinct number ...");

                    System.out.print("How many numbers: ");
                    int size = input.nextInt();

                    int[] arr = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print("Input value " + (i + 1) + ": ");
                        arr[i] = input.nextInt();
                    }

                    System.out.println("Distinct count is: "
                            + math.countDistinct(arr));

                    break;

                case 4:

                    System.out.println("\n... Decimal to Binary ...");

                    System.out.print("Input decimal number: ");
                    int dec = input.nextInt();

                    System.out.println("Binary is: "
                            + math.decimalToBinary(dec));

                    break;

                case 5:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

            System.out.println();

        } while (choice != 5);

        input.close();
    }
}