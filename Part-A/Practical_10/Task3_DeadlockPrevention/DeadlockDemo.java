import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DeadlockDemo {
    private final int id;
    private long balance;
    public DeadlockDemo(int id, long balance) { this.id = id; this.balance = balance; }

    public static void transfer(DeadlockDemo from, DeadlockDemo to, long amount) {
        DeadlockDemo first = from.id < to.id ? from : to;
        DeadlockDemo second = first == from ? to : from;
        synchronized (first) {
            synchronized (second) {
                if (amount <= 0 || from.balance < amount) throw new IllegalArgumentException("Invalid transfer.");
                from.balance -= amount;
                to.balance += amount;
            }
        }
    }

    public static void demonstrateDeadlock() throws InterruptedException {
        Object left = new Object();
        Object right = new Object();
        CountDownLatch bothHoldOneLock = new CountDownLatch(2);
        Thread first = new Thread(() -> {
            synchronized (left) {
                bothHoldOneLock.countDown();
                awaitOtherThread(bothHoldOneLock);
                synchronized (right) { System.out.println("First thread acquired both locks."); }
            }
        }, "left-then-right");
        Thread second = new Thread(() -> {
            synchronized (right) {
                bothHoldOneLock.countDown();
                awaitOtherThread(bothHoldOneLock);
                synchronized (left) { System.out.println("Second thread acquired both locks."); }
            }
        }, "right-then-left");
        first.setDaemon(true);
        second.setDaemon(true);
        first.start();
        second.start();
        bothHoldOneLock.await(2, TimeUnit.SECONDS);
        first.join(200);
        second.join(200);
        System.out.println("Opposite lock order: " + first.getState() + " / " + second.getState());
        System.out.println("Both threads are blocked, demonstrating deadlock.");
    }

    private static void awaitOtherThread(CountDownLatch latch) {
        try { latch.await(); }
        catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
    }

    public synchronized long getBalance() { return balance; }
}
