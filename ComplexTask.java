import java.util.*;

class ComplexTask extends Task {
    private List<Task> subTasks;

    public ComplexTask(String name, String status) {
        super(name, status);
        this.subTasks = new ArrayList<>();
    }

    public void addSubTask(Task task) {
        subTasks.add(task);
    }

    @Override
    public int estimateDuration() {
        return subTasks.stream().mapToInt(Task::estimateDuration).sum();
    }
}
