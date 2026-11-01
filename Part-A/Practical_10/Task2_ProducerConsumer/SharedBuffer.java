import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    public SharedBuffer(int capacity) { this.capacity = capacity; }
    public synchronized void put(int value) throws InterruptedException {
        while (queue.size() == capacity) wait();
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }
    public synchronized int take() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int value = queue.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}
