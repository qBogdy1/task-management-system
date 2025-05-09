import java.util.*;

class TasksManagement {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void assignTaskToEmployee(String employeeName, Task task) {
        employees.stream()
                .filter(e -> e.getName().equals(employeeName))
                .findFirst()
                .ifPresent(e -> e.assignTask(task));
    }

    public int calculateEmployeeWorkDuration(String employeeName) {
        return employees.stream()
                .filter(e -> e.getName().equals(employeeName))
                .findFirst()
                .map(Employee::calculateWorkDuration)
                .orElse(0);
    }

    public void modifyTaskStatus(String employeeName, String taskName, String newStatus) {
        employees.stream()
                .filter(e -> e.getName().equals(employeeName))
                .findFirst()
                .ifPresent(e -> e.getTasks().stream()
                        .filter(t -> t.name.equals(taskName))
                        .findFirst()
                        .ifPresent(t -> t.setStatus(newStatus)));
    }
}