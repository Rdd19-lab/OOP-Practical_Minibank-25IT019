import java.nio.file.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        Path one = Path.of("app.log"), two = Path.of("server.log");
        Files.writeString(one, "INFO Started\nERROR Disk full\nINFO Retrying\n");
        Files.writeString(two, "WARN Delay\nERROR Timeout\n");
        LogAnalyzer.analyze(one, "ERROR");
        LogAnalyzer.analyze(two, "ERROR");
        Files.deleteIfExists(one); Files.deleteIfExists(two);
    }
}
