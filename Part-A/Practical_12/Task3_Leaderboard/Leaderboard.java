import java.util.*;

public class Leaderboard {
    public static List<Map.Entry<String, Integer>> top(Map<String, Integer> scores, int n) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));
        return entries.subList(0, Math.min(Math.max(n, 0), entries.size()));
    }
}
