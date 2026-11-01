import java.nio.file.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        Path root = Path.of("sample-folder");
        Files.createDirectories(root);
        Files.writeString(root.resolve("notes.txt"), "OOP practical report");
        Files.writeString(root.resolve("data.csv"), "id,name\n1,Aarav");
        for (String row : DirectoryReport.create(root)) System.out.println(row);
        System.out.println("Report saved to " + root.resolve("directory-report.txt"));
    }
}
