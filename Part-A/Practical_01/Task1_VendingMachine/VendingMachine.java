import java.util.Scanner;

public class VendingMachine {
    enum Coin {
        ONE(1), TWO(2), FIVE(5), TEN(10);
        final int value;
        Coin(int value) { this.value = value; }
    }

    public static void main(String[] args) {
        final int price = 15;
        int paid = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Snack price: Rs. " + price);
            while (paid < price) {
                System.out.print("Insert coin (ONE, TWO, FIVE, TEN): ");
                Coin coin = Coin.valueOf(sc.next().trim().toUpperCase());
                paid += switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };
                System.out.println("Total paid: Rs. " + paid);
            }
            System.out.println("Paid. Change: " + (paid - price));
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid coin. Use ONE, TWO, FIVE or TEN.");
        }
    }
}
