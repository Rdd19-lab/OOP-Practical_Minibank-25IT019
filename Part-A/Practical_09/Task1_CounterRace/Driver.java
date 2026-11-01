public class Driver {
    private static Counter run(boolean safe) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[8];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    if (safe) counter.incrementSafe(); else counter.incrementUnsafe();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();
        return counter;
    }
    public static void main(String[] args) throws InterruptedException {
        Counter unsafe = run(false);
        Counter safe = run(true);
        System.out.println("Expected count: 80000");
        System.out.println("Without synchronization: " + unsafe.getCount());
        System.out.println("With synchronization: " + safe.getCount());
    }
}
