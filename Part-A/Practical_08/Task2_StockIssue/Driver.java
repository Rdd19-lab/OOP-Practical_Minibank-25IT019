public class Driver {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        for (int quantity : new int[]{2, 5}) {
            try {
                warehouse.issue("Keyboard", quantity);
                System.out.println("Issued " + quantity + " keyboards.");
            } catch (Exception ex) {
                System.out.println("Issue failed: " + ex.getMessage());
            }
        }
        System.out.println("Remaining: " + warehouse.available("Keyboard"));
    }
}
