public class Driver {
    public static void main(String[] args) throws InterruptedException {
        DeadlockDemo.demonstrateDeadlock();
        DeadlockDemo a = new DeadlockDemo(1, 1000);
        DeadlockDemo b = new DeadlockDemo(2, 1000);
        Thread t1 = new Thread(() -> DeadlockDemo.transfer(a, b, 100));
        Thread t2 = new Thread(() -> DeadlockDemo.transfer(b, a, 50));
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println("Account 1 balance: " + a.getBalance());
        System.out.println("Account 2 balance: " + b.getBalance());
        System.out.println("Consistent lock ordering let both transfers finish without deadlock.");
    }
}
