public class WorkSession implements AutoCloseable {
    private boolean closed;
    public WorkSession() { System.out.println("Session opened."); }
    public void perform() {
        if (closed) throw new IllegalStateException("Session is closed.");
        System.out.println("Work performed.");
    }
    @Override public void close() {
        closed = true;
        System.out.println("Session closed.");
    }
}
