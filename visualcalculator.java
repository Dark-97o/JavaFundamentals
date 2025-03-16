import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton[] buttons;
    private String[] operations = {"Add", "Subtract", "Multiply", "Divide"};

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        buttons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(operations[i]);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        add(new JLabel("Enter first number:")); add(num1Field);
        add(new JLabel("Enter second number:")); add(num2Field);
        add(new JLabel("Result:")); add(resultField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = switch (e.getActionCommand()) {
                case "Add" -> num1 + num2;
                case "Subtract" -> num1 - num2;
                case "Multiply" -> num1 * num2;
                case "Divide" -> (num2 != 0) ? num1 / num2 : throw new ArithmeticException("Cannot divide by zero!");
                default -> 0;
            };
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}
