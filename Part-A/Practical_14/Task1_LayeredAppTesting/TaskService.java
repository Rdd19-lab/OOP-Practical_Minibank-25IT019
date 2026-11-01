import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    public void addTask(String title) { tasks.add(new Task(title)); }
    public int getCount() { return tasks.size(); }
    public List<Task> getTasks() { return List.copyOf(tasks); }
}
