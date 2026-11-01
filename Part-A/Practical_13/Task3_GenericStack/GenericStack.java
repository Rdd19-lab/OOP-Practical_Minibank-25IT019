import java.util.NoSuchElementException;

public class GenericStack<T> {
    private final Object[] values;
    private int size;
    public GenericStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        values = new Object[capacity];
    }
    public void push(T value) {
        if (size == values.length) throw new IllegalStateException("Stack is full.");
        values[size++] = value;
    }
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) throw new NoSuchElementException("Stack is empty.");
        T value = (T) values[--size];
        values[size] = null;
        return value;
    }
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new NoSuchElementException("Stack is empty.");
        return (T) values[size - 1];
    }
    public boolean isEmpty() { return size == 0; }
}
