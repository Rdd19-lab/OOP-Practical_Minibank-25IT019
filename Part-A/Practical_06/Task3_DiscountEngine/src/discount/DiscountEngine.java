package discount;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class DiscountEngine {
    private static final Map<String, DoubleUnaryOperator> RULES = Map.of(
            "none", price -> price,
            "student", price -> price * 0.90,
            "festival", price -> price * 0.80
    );

    public static void main(String[] args) {
        List<Double> prices = List.of(2500.0, 1200.0, 750.0);
        System.out.println("Available rules: none, student (10% off), festival (20% off)");
        System.out.print("Choose a discount rule: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            DoubleUnaryOperator rule = RULES.get(choice);
            if (rule == null) {
                System.out.println("Unknown rule. Choose none, student, or festival.");
                return;
            }
            double total = 0;
            for (double price : prices) {
                double discounted = rule.applyAsDouble(price);
                total += discounted;
                System.out.printf("Rs. %.2f -> Rs. %.2f%n", price, discounted);
            }
            System.out.printf("Total: Rs. %.2f%n", total);
        }
    }
}
