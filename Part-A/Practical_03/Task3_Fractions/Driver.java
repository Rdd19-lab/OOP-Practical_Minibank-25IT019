public class Driver {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(2, 4);
        Fraction c = a.add(new Fraction(1, 3));
        System.out.println("First: " + a);
        System.out.println("Second: " + b);
        System.out.println("Equivalent: " + a.equals(b));
        System.out.println("Sum: " + c);
    }
}
