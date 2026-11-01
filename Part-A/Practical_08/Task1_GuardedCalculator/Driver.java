import java.util.Scanner;

public class Driver {
    static double calculate(double a, String operator, double b) throws DivideByZeroException {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new DivideByZeroException("Cannot divide by zero.");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator.");
        };
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            try {
                System.out.print("First number: "); double a = Double.parseDouble(sc.nextLine());
                System.out.print("Operator (+,-,*,/): "); String op = sc.nextLine().trim();
                System.out.print("Second number: "); double b = Double.parseDouble(sc.nextLine());
                System.out.println("Result: " + calculate(a, op, b));
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            } catch (DivideByZeroException ex) {
                System.out.println(ex.getMessage());
            } finally {
                System.out.println("Calculation attempt completed.");
            }
        }
    }
}
