public class Driver {
    public static void main(String[] args) {
        try (WorkSession session = new WorkSession()) {
            session.perform();
        }
        System.out.println("Resources released safely.");
    }
}
