package edu.charusat.tasks;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class TaskStoreTest {
    @Test void savesAndReloadsTasksUnchanged() throws Exception {
        TaskService service = new TaskService();
        service.addTask("Record project demo");
        Path file = Files.createTempFile("tasks", ".dat");
        try {
            TaskStore store = new TaskStore();
            store.save(service, file);
            assertEquals("Record project demo", store.load(file).get(0).getTitle());
        } finally {
            Files.deleteIfExists(file);
        }
    }
}
