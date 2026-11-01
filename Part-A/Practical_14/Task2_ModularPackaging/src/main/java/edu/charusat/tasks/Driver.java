package edu.charusat.tasks;

import java.nio.file.Path;

public class Driver {
    public static void main(String[] args) throws Exception {
        TaskService service = new TaskService();
        service.addTask("Complete Java OOP practical journal");
        service.addTask("Prepare MiniBank demonstration");
        TaskStore store = new TaskStore();
        Path file = Path.of("tasks.dat");
        store.save(service, file);
        var loaded = store.load(file);
        System.out.println("Saved tasks: " + service.getCount());
        System.out.println("Reloaded tasks: " + loaded.size());
        loaded.forEach(System.out::println);
    }
}
