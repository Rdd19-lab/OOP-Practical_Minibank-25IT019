public class TaskRunner implements Runnable {
    private final int taskId;
    public TaskRunner(int taskId) { this.taskId = taskId; }
    @Override public void run() {
        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
        try { Thread.sleep(100); }
        catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
    }
}
