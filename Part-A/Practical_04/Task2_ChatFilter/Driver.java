import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String[] logs = {
                "10:05 alice Hello there",
                "10:07 bob Need help with the assignment",
                "malformed"
        };
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Keyword: ");
            String keyword = scanner.nextLine().trim();
            ChatFilter filter = new ChatFilter();
            String report = filter.filter(logs, keyword);
            System.out.println("Matches: " + filter.getMatchCount());
            if (!report.isEmpty()) System.out.println(report);
        }
    }
}
