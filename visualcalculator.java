import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class visualcalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel buttonPanel;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    public visualcalculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Create the display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setText("0");
        add(display, BorderLayout.NORTH);

        // Create button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Define all buttons
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "←", "", ""  // C for clear, ← for backspace, two empty slots
        };
        
        // Create and add buttons to panel
        for (String label : buttonLabels) {
            if (label.isEmpty()) {
                // Add empty panel for blank spaces
                buttonPanel.add(new JPanel());
                continue;
            }
            
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            
            // Set different background for numeric and operation buttons
            if (label.matches("[0-9.]")) {
                button.setBackground(new Color(240, 240, 240));
            } else {
                button.setBackground(new Color(220, 220, 220));
                if (label.equals("=")) {
                    button.setBackground(new Color(150, 200, 250));
                }
            }
            
            buttonPanel.add(button);
        }
        
        // Add padding around the button panel
        JPanel paddedPanel = new JPanel();
        paddedPanel.setLayout(new BorderLayout());
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        paddedPanel.add(buttonPanel, BorderLayout.CENTER);
        
        add(paddedPanel, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        // Check if button is a digit or decimal point
        if (command.matches("[0-9.]")) {
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                // Prevent multiple decimal points
                if (command.equals(".") && display.getText().contains(".")) {
                    return;
                }
                
                // Don't show leading zero for numbers
                if (display.getText().equals("0") && !command.equals(".")) {
                    display.setText(command);
                } else {
                    display.setText(display.getText() + command);
                }
            }
        }
        // Check if button is an operator
        else if (command.matches("[+\\-*/]")) {
            if (!operator.isEmpty()) {
                // If an operator was already clicked, perform the calculation first
                calculate();
            }
            
            num1 = Double.parseDouble(display.getText());
            operator = command;
            isOperatorClicked = true;
        }
        // Check if equals button is clicked
        else if (command.equals("=")) {
            calculate();
            operator = "";
        }
        // Check if clear button is clicked
        else if (command.equals("C")) {
            display.setText("0");
            num1 = num2 = result = 0;
            operator = "";
            isOperatorClicked = false;
        }
        // Check if backspace button is clicked
        else if (command.equals("←")) {
            String currentText = display.getText();
            if (currentText.length() > 0) {
                // Remove the last character
                String newText = currentText.substring(0, currentText.length() - 1);
                display.setText(newText.isEmpty() ? "0" : newText);
            }
        }
    }
    
    private void calculate() {
        if (!operator.isEmpty()) {
            num2 = Double.parseDouble(display.getText());
            
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            
            // Format the result to avoid unnecessary decimal places
            String resultStr = (result == (long) result) 
                             ? String.format("%d", (long) result) 
                             : String.format("%s", result);
            
            display.setText(resultStr);
            num1 = result;
            isOperatorClicked = true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new visualcalculator().setVisible(true);
            }
        });
    }
}