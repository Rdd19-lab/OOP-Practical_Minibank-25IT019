import java.util.Locale;

public class ChatFilter {
    private int matchCount;

    public String filter(String[] logLines, String keyword) {
        if (logLines == null) throw new IllegalArgumentException("Log lines cannot be null.");
        if (keyword == null || keyword.isBlank()) throw new IllegalArgumentException("Keyword cannot be blank.");
        matchCount = 0;
        StringBuilder report = new StringBuilder();
        for (String line : logLines) {
            if (line == null) continue;
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) continue;
            if (parts[2].toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                if (report.length() > 0) report.append(System.lineSeparator());
                report.append(parts[0]).append(' ').append(parts[1]).append(": ").append(parts[2]);
                matchCount++;
            }
        }
        return report.toString();
    }

    public int getMatchCount() { return matchCount; }
}
