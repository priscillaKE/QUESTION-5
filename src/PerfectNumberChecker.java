import java.util.InputMismatchException;
import java.util.Scanner;

public class PerfectNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        while (true) {
            try {
                System.out.print("Enter a positive integer: ");
                number = input.nextInt();

                if (number <= 0) {
                    System.out.println("Invalid input. Number must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum == number) {
            System.out.println(number + " is a PERFECT number.");
        } else {
            System.out.println(number + " is NOT a perfect number.");
        }

        input.close();
    }
}
