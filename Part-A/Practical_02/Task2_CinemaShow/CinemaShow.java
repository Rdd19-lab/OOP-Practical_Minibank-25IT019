public class CinemaShow {
    private static int totalBooked;
    private final String title;
    private final int capacity;
    private int seatsAvailable;

    public CinemaShow(String title, int capacity) {
        if (title == null || title.isBlank() || capacity <= 0)
            throw new IllegalArgumentException("Invalid title or capacity.");
        this.title = title;
        this.capacity = capacity;
        seatsAvailable = capacity;
    }

    public CinemaShow(String title) { this(title, 100); }

    public boolean book(int seats) {
        if (seats <= 0 || seats > seatsAvailable) return false;
        seatsAvailable -= seats;
        totalBooked += seats;
        return true;
    }

    public void cancel(int seats) {
        if (seats > 0) seatsAvailable = Math.min(capacity, seatsAvailable + seats);
    }

    public int getSeatsAvailable() { return seatsAvailable; }
    public static int getTotalBooked() { return totalBooked; }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("The Java Adventure", 20);
        System.out.println(show.title + " booking 12 seats: " + show.book(12) + ", seats left: " + show.getSeatsAvailable());
        System.out.println(show.title + " booking 10 seats: " + show.book(10) + ", seats left: " + show.getSeatsAvailable());
        show.cancel(4);
        System.out.println("Cancelled 4 seats; seats left: " + show.getSeatsAvailable());
        System.out.println("Total seats booked: " + getTotalBooked());
    }
}
