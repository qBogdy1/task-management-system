import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManagementGUI {
    private TasksManagement taskManager =new TasksManagement();
    private JFrame frame;
    private JTextField employeeNameField, taskNameField, startHourField, endHourField, statusField;
    private JTextArea displayArea;

    public TaskManagementGUI() {
        frame = new JFrame("Task Management");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(255, 250, 200));
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(255, 245, 180));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);
        JLabel titleLabel = new JLabel("Task Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(titleLabel, BorderLayout.NORTH);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Employee Name:"), gbc);
        gbc.gridx = 1;
        employeeNameField = new JTextField(15);
        panel.add(employeeNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Task Name:"), gbc);
        gbc.gridx = 1;
        taskNameField = new JTextField(15);
        panel.add(taskNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Start Hour:"), gbc);
        gbc.gridx = 1;
        startHourField = new JTextField(15);
        panel.add(startHourField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("End Hour:"), gbc);
        gbc.gridx = 1;
        endHourField = new JTextField(15);
        panel.add(endHourField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Task Status (Completed/Uncompleted):"), gbc);
        gbc.gridx = 1;
        statusField = new JTextField(15);
        panel.add(statusField, gbc);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(180, 200, 250));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JButton addButton = new JButton("Add Employee");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(128, 0, 128));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> addEmployee());
        buttonPanel.add(addButton);
        JButton taskButton = new JButton("Assign Task");
        taskButton.setFont(new Font("Arial", Font.BOLD, 14));
        taskButton.setBackground(new Color(128, 0, 128));
        taskButton.setForeground(Color.WHITE);
        taskButton.addActionListener(e -> assignTask());
        buttonPanel.add(taskButton);
        JButton statusButton = new JButton("Modify Task Status");
        statusButton.setFont(new Font("Arial", Font.BOLD, 14));
        statusButton.setBackground(new Color(128, 0, 128));
        statusButton.setForeground(Color.WHITE);
        statusButton.addActionListener(e -> modifyTaskStatus());
        buttonPanel.add(statusButton);
        JButton calculateButton = new JButton("Calculate Work Duration");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setBackground(new Color(128, 0, 128));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(e -> calculateWorkDuration());
        buttonPanel.add(calculateButton);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(new JScrollPane(displayArea), BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addEmployee() {
        String name =employeeNameField.getText();
        taskManager.addEmployee(new Employee(name));
        displayArea.append("Added employee: " + name + "\n");
    }

    private void assignTask() {
        String empName = employeeNameField.getText();
        String taskName = taskNameField.getText();
        int startHour = Integer.parseInt(startHourField.getText());
        int endHour = Integer.parseInt(endHourField.getText());
        Task task = new SimpleTask(taskName, "Uncompleted", startHour, endHour);
        taskManager.assignTaskToEmployee(empName, task);
        displayArea.append("Assigned task: " + taskName + " to " + empName + "\n");
    }

    private void modifyTaskStatus() {
        String empName= employeeNameField.getText();
        String taskName= taskNameField.getText();
        String status =statusField.getText();
        taskManager.modifyTaskStatus(empName, taskName, status);
        displayArea.append("Updated task: "+ taskName + " to " + status + "\n");
    }

    private void calculateWorkDuration() {
        String empName= employeeNameField.getText();
        int duration =taskManager.calculateEmployeeWorkDuration(empName);
        displayArea.append("Employee " + empName + " has worked " + duration + " hours\n");
    }

    public static void main(String[] args) {
        new TaskManagementGUI();
    }
}
