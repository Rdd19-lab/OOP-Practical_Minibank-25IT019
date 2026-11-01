package edu.charusat.tasks;

import java.io.*;
import java.nio.file.*;

public class TaskStore {
    public void save(TaskService service, Path file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(new java.util.ArrayList<>(service.getTasks()));
        }
    }
    @SuppressWarnings("unchecked")
    public java.util.List<Task> load(Path file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return (java.util.List<Task>) in.readObject();
        }
    }
}
