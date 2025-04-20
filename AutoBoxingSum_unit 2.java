package Unit2;

import java.util.*;

public class AutoBoxingSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) break;
            try {
                Integer num = Integer.parseInt(input); // autoboxing
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter an integer.");
            }
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // unboxing
        }

        System.out.println("Sum: " + sum);
    }
}
