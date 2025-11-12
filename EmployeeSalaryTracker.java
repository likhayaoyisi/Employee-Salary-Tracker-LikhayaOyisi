import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeSalaryTracker extends JFrame {
    private JTextField nameField, scoreField, salesField, yearsField;
    private JComboBox<String> roleComboBox;
    private JTextArea resultArea;

    public EmployeeSalaryTracker() {
        setTitle("Employee Salary Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Employee Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Performance Score:"));
        scoreField = new JTextField();
        add(scoreField);

        add(new JLabel("Sales Made:"));
        salesField = new JTextField();
        add(salesField);

        add(new JLabel("Years Worked:"));
        yearsField = new JTextField();
        add(yearsField);

        add(new JLabel("Role:"));
        String[] roles = {"Cybersecurity", "Generative AI", "AI Automation", "Database Management", "Web Development"};
        roleComboBox = new JComboBox<>(roles);
        add(roleComboBox);

        JButton calculateButton = new JButton("Calculate Salary");
        add(calculateButton);
        resultArea = new JTextArea();
        add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSalary();
            }
        });
    }

    private void calculateSalary() {
        String name = nameField.getText();
        int score = Integer.parseInt(scoreField.getText());
        int sales = Integer.parseInt(salesField.getText());
        int years = Integer.parseInt(yearsField.getText());
        String role = (String) roleComboBox.getSelectedItem();

        double baseSalary = 17000;
        double performanceBonus = score * 10;
        double salesBonus = sales * 20;
        double experienceBonus = years * 150;
        double totalSalary = baseSalary + performanceBonus + salesBonus + experienceBonus;

        resultArea.setText("Total Salary for " + name + ": R" + totalSalary);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeSalaryTracker tracker = new EmployeeSalaryTracker();
            tracker.setVisible(true);
        });
    }
}