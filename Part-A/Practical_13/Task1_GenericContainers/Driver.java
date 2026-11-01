public class Driver {
    public static <T> T getFirst(T[] values) {
        if (values == null || values.length == 0) return null;
        return values[0];
    }
    public static void main(String[] args) {
        Box<String> text = new Box<>(); text.set("Generics in Java");
        Box<Integer> number = new Box<>(); number.set(100);
        Pair<String, Double> pair = new Pair<>("Balance", 4500.50);
        String[] names = {"Aarav", "Diya", "Karan"};
        System.out.println("String box: " + text.get());
        System.out.println("Integer box: " + number.get());
        System.out.println("Pair: " + pair);
        System.out.println("First: " + getFirst(names));
    }
}
