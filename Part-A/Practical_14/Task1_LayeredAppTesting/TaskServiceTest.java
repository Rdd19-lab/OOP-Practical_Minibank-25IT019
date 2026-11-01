import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    @Test void addingTaskIncreasesCount() {
        TaskService service = new TaskService();
        service.addTask("Complete OOP practical");
        assertEquals(1, service.getCount());
    }
    @Test void blankTaskThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(" "));
    }
    @Test void taskTitleIsTrimmed() {
        assertEquals("Java OOP", new Task(" Java OOP ").getTitle());
    }
}
