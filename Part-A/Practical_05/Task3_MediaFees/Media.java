abstract class Media {
    protected final String title;
    protected final int daysLate;
    Media(String title, int daysLate) { this.title = title; this.daysLate = Math.max(0, daysLate); }
    abstract double lateFee();
}
class Book extends Media {
    Book(String title, int daysLate) { super(title, daysLate); }
    @Override double lateFee() { return daysLate * 2.0; }
}
class DVD extends Media {
    DVD(String title, int daysLate) { super(title, daysLate); }
    @Override double lateFee() { return daysLate * 5.0; }
}
class Magazine extends Media {
    Magazine(String title, int daysLate) { super(title, daysLate); }
    @Override double lateFee() { return daysLate * 1.5; }
}
