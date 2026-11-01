public class Driver {
    public static void main(String[] args) {
        String text = "Java is great and Java is fast. Fast code is clean code!";
        for (var entry : WordCounter.sorted(WordCounter.count(text)))
            System.out.printf("%-10s : %d%n", entry.getKey(), entry.getValue());
    }
}
