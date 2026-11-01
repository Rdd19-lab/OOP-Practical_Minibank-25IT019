public class Driver {
    public static void main(String[] args) {
        Media[] items = {new Book("Java Basics", 3), new DVD("OOP Tutorial", 2), new Magazine("Tech Today", 4)};
        double total = 0;
        for (Media item : items) {
            double fee = item.lateFee();
            total += fee;
            System.out.printf("%s late fee: Rs. %.2f%n", item.title, fee);
        }
        System.out.printf("Total late fees: Rs. %.2f%n", total);
    }
}
