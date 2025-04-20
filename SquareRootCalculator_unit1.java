import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();

            if (num < 0) {
                throw new ArithmeticException("Cannot calculate square root of a negative number.");
            }

            System.out.println("Square root: " + Math.sqrt(num));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
