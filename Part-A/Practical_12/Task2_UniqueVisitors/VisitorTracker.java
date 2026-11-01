import java.util.*;

public class VisitorTracker {
    private final Set<String> unique = new HashSet<>();
    private final Set<String> order = new LinkedHashSet<>();
    public void record(String name) { unique.add(name); order.add(name); }
    public int uniqueCount() { return unique.size(); }
    public List<String> firstThree() { return order.stream().limit(3).toList(); }
}
