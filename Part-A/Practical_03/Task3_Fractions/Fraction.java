public class Fraction {
    private final int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        int sign = denominator < 0 ? -1 : 1;
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = sign * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    private static int gcd(int a, int b) { return b == 0 ? Math.max(1, a) : gcd(b, a % b); }
    public Fraction add(Fraction f) {
        return new Fraction(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
    }
    @Override public String toString() { return numerator + "/" + denominator; }
    @Override public boolean equals(Object o) {
        return o instanceof Fraction f && numerator == f.numerator && denominator == f.denominator;
    }
    @Override public int hashCode() { return 31 * numerator + denominator; }
}
