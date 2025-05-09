import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private String name;
    private List<Task> tasks;

    public Employee(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }
    public void assignTask(Task task) {
        tasks.add(task);
    }
    public int calculateWorkDuration() {
        return tasks.stream()
                .filter(t -> "Completed".equals(t.getStatus()))
                .mapToInt(Task::estimateDuration)
                .sum();
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public String getName() {
        return name;
    }
}