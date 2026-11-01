public class Counter {
    private int count;
    public void incrementUnsafe() {
        int observed = count;
        Thread.yield();
        count = observed + 1;
    }
    public synchronized void incrementSafe() { count++; }
    public synchronized int getCount() { return count; }
}
