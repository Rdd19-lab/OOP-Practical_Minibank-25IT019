import java.util.concurrent.CountDownLatch;

public class CinemaBooking {
    private int availableSeats;

    public CinemaBooking(int seatCount) {
        if (seatCount <= 0) throw new IllegalArgumentException("Seat count must be positive.");
        availableSeats = seatCount;
    }

    public boolean bookUnsafely(String customer, CountDownLatch allRead) throws InterruptedException {
        int observedSeats = availableSeats;
        allRead.countDown();
        allRead.await();
        if (observedSeats == 0) return false;
        availableSeats = observedSeats - 1;
        return true;
    }

    public synchronized boolean bookSafely(String customer) {
        if (availableSeats == 0) return false;
        availableSeats--;
        return true;
    }

    public synchronized int getAvailableSeats() { return availableSeats; }
}
