public class BookingDriver {
    public static void main(String[] args) throws InterruptedException {
        runBookingRound(false);
        runBookingRound(true);
    }

    private static void runBookingRound(boolean safe) throws InterruptedException {
        int attempts = 10;
        CinemaBooking booking = new CinemaBooking(5);
        java.util.concurrent.CountDownLatch ready = new java.util.concurrent.CountDownLatch(attempts);
        java.util.concurrent.CountDownLatch start = new java.util.concurrent.CountDownLatch(1);
        java.util.concurrent.CountDownLatch allRead = safe ? null : new java.util.concurrent.CountDownLatch(attempts);
        java.util.concurrent.atomic.AtomicInteger successful = new java.util.concurrent.atomic.AtomicInteger();
        Thread[] guests = new Thread[attempts];
        for (int i = 0; i < attempts; i++) {
            final String name = "Guest-" + (i + 1);
            guests[i] = new Thread(() -> {
                ready.countDown();
                try {
                    start.await();
                    boolean booked = safe ? booking.bookSafely(name) : booking.bookUnsafely(name, allRead);
                    if (booked) successful.incrementAndGet();
                } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
            });
            guests[i].start();
        }
        ready.await();
        start.countDown();
        for (Thread guest : guests) guest.join();
        System.out.println((safe ? "Synchronized" : "Unsynchronized") + " bookings: " + successful.get()
                + "; seats left: " + booking.getAvailableSeats());
    }
}
