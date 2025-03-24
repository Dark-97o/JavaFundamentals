import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class visualcalculator extends JFrame {
    private JTextField display;
    private double num1 = 0, num2 = 0;
    private String operator = "";
    private boolean isNewInput = true;

    public visualcalculator() {
        setTitle("Calculator");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        
        JPanel btnPanel = new JPanel(new GridLayout(5, 4, 2, 2));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };
        
        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.addActionListener(e -> processButton(label));
            btnPanel.add(btn);
        }
        
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
    }
    
    private void processButton(String command) {
        // Handle numbers and decimal
        if (command.matches("[0-9.]")) {
            if (isNewInput) {
                display.setText(command.equals(".") ? "0." : command);
                isNewInput = false;
            } else {
                // Prevent multiple decimal points
                if (command.equals(".") && display.getText().contains(".")) {
                    return;
                }
                display.setText(display.getText() + command);
            }
        }
        // Handle operators
        else if (command.matches("[+\\-*/]")) {
            calculate();
            num1 = Double.parseDouble(display.getText());
            operator = command;
            isNewInput = true;
        }
        // Handle equals
        else if (command.equals("=")) {
            calculate();
            operator = "";
        }
        // Handle clear
        else if (command.equals("C")) {
            display.setText("0");
            num1 = num2 = 0;
            operator = "";
            isNewInput = true;
        }
    }
    
    private void calculate() {
        if (!operator.isEmpty() && !isNewInput) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;
            
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 != 0) result = num1 / num2;
                    else { display.setText("Error"); return; }
                    break;
            }
            
            // Format result (remove .0 for integers)
            display.setText(result % 1 == 0 ? String.valueOf((int)result) : String.valueOf(result));
            num1 = result;
            isNewInput = true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new visualcalculator().setVisible(true));
    }
}