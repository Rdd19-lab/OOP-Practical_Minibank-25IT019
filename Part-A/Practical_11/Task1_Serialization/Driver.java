import java.io.*;
import java.nio.file.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        Student[] students = {new Student(101, "Aarav", "secret1"), new Student(102, "Diya", "secret2")};
        Path file = Path.of("students.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(students);
        }
        Student[] loaded;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            loaded = (Student[]) in.readObject();
        }
        System.out.println("Saved and loaded: " + loaded.length + " students");
        for (Student student : loaded) System.out.println(student);
        Files.deleteIfExists(file);
    }
}
