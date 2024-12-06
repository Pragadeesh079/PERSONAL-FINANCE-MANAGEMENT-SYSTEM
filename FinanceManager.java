import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceManager extends JFrame {
    private JTextField incomeField;
    private JTextField expensesField;
    private JTextField investmentsField;
    private JTextArea resultArea;

    private double totalIncome = 0.0;
    private double totalExpenses = 0.0;
    private double totalInvestments = 0.0;

    public FinanceManager() {
        setTitle("Finance Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        JLabel incomeLabel = new JLabel("Monthly Income:");
        incomeField = new JTextField(10);

        JLabel expensesLabel = new JLabel("Monthly Expenses:");
        expensesField = new JTextField(10);

        JLabel investmentsLabel = new JLabel("Monthly Investments:");
        investmentsField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate Savings");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");
        
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Add action listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSavings();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add components to the frame
        add(incomeLabel);
        add(incomeField);
        add(expensesLabel);
        add(expensesField);
        add(investmentsLabel);
        add(investmentsField);
        add(calculateButton);
        add(clearButton);
        add(exitButton);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    private void calculateSavings() {
        try {
            totalIncome = Double.parseDouble(incomeField.getText());
            totalExpenses = Double.parseDouble(expensesField.getText());
            totalInvestments = Double.parseDouble(investmentsField.getText());

            double savings = totalIncome - (totalExpenses + totalInvestments);
            resultArea.setText("Total Monthly Income: " + totalIncome + "\n" +
                               "Total Monthly Expenses: " + totalExpenses + "\n" +
                               "Total Monthly Investments: " + totalInvestments + "\n" +
                               "Remaining Savings: " + savings);
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numbers.");
        }
    }

    private void clearFields() {
        incomeField.setText("");
        expensesField.setText("");
        investmentsField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FinanceManager();
            }
        });
    }
}