import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<String, Integer> stock = new HashMap<>();
    public Warehouse() { stock.put("Keyboard", 5); stock.put("Mouse", 3); }
    public void issue(String item, int quantity) throws Exception {
        int available = stock.getOrDefault(item, 0);
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        if (available < quantity) throw new Exception("Out of stock: requested " + quantity + ", available " + available);
        stock.put(item, available - quantity);
    }
    public int available(String item) { return stock.getOrDefault(item, 0); }
}
