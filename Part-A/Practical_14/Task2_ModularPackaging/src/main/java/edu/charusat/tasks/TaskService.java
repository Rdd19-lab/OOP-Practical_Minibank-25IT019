package edu.charusat.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    public void addTask(String title) { tasks.add(new Task(title)); }
    public List<Task> getTasks() { return List.copyOf(tasks); }
    public int getCount() { return tasks.size(); }
}
