public class Driver {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer(2);
        Thread producer = new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) buffer.put(i); }
            catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) buffer.take(); }
            catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
        producer.join(); consumer.join();
        System.out.println("Producer-consumer completed.");
    }
}
