import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DirectoryReport {
    public static List<String> create(Path root) throws IOException {
        List<String> rows = new ArrayList<>();
        try (var paths = Files.walk(root)) {
            for (Path path : paths.filter(Files::isRegularFile).toList()) {
                BasicFileAttributes a = Files.readAttributes(path, BasicFileAttributes.class);
                rows.add(path.getFileName() + " | " + a.size() + " bytes | " + a.lastModifiedTime());
            }
        }
        Path report = root.resolve("directory-report.txt");
        Files.write(report, rows);
        return rows;
    }
}
