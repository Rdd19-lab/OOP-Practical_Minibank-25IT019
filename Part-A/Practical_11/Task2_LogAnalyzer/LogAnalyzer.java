import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void analyze(Path file, String keyword) throws IOException {
        List<String> lines = Files.readAllLines(file);
        long matches = lines.stream().filter(line -> line.contains(keyword)).count();
        BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println(file.getFileName() + " | Size: " + attributes.size() + " bytes");
        System.out.println("Total lines: " + lines.size() + " | Matches for '" + keyword + "': " + matches);
    }
}
