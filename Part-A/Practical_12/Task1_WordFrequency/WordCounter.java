import java.util.*;

public class WordCounter {
    public static Map<String, Integer> count(String text) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : text.toLowerCase().split("[^a-z0-9]+"))
            if (!word.isBlank()) counts.put(word, counts.getOrDefault(word, 0) + 1);
        return counts;
    }
    public static List<Map.Entry<String, Integer>> sorted(Map<String, Integer> counts) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));
        return list;
    }
}
