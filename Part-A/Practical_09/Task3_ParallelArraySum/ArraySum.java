import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.CyclicBarrier;

public class ArraySum {
    private final long[] values;
    public ArraySum(long[] values) { this.values = values.clone(); }

    public long sumUnsafely(int threadCount) throws InterruptedException {
        validateThreadCount(threadCount);
        Thread[] workers = new Thread[threadCount];
        int chunk = (values.length + threadCount - 1) / threadCount;
        long[] total = {0};
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunk, end = Math.min(values.length, (i + 1) * chunk);
            workers[i] = new Thread(() -> {
                long local = partialSum(start, end);
                try { barrier.await(); }
                catch (Exception ex) { Thread.currentThread().interrupt(); return; }
                long observed = total[0];
                try { barrier.await(); }
                catch (Exception ex) { Thread.currentThread().interrupt(); return; }
                total[0] = observed + local;
            });
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        return total[0];
    }

    public long sumWithSynchronization(int threadCount) throws InterruptedException {
        validateThreadCount(threadCount);
        Thread[] workers = new Thread[threadCount];
        int chunk = (values.length + threadCount - 1) / threadCount;
        long[] total = {0};
        Object lock = new Object();
        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunk, end = Math.min(values.length, (i + 1) * chunk);
            workers[i] = new Thread(() -> {
                long local = partialSum(start, end);
                synchronized (lock) { total[0] += local; }
            });
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        return total[0];
    }

    public long sumWithLongAdder(int threadCount) throws InterruptedException {
        validateThreadCount(threadCount);
        Thread[] workers = new Thread[threadCount];
        int chunk = (values.length + threadCount - 1) / threadCount;
        LongAdder total = new LongAdder();
        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunk, end = Math.min(values.length, (i + 1) * chunk);
            workers[i] = new Thread(() -> total.add(partialSum(start, end)));
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        return total.sum();
    }

    private long partialSum(int start, int end) {
        long result = 0;
        for (int i = start; i < end; i++) result += values[i];
        return result;
    }

    private static void validateThreadCount(int threadCount) {
        if (threadCount <= 0) throw new IllegalArgumentException("Thread count must be positive.");
    }
}
