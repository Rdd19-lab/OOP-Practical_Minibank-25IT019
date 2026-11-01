import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        Map<String, Integer> scores = Map.of("Aarav", 95, "Diya", 98, "Karan", 95, "Riya", 91);
        System.out.println("Top players:");
        for (var e : Leaderboard.top(scores, 3)) System.out.println(e.getKey() + " - " + e.getValue());
    }
}
