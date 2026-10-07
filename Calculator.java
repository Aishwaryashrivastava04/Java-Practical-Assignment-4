import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField num1Field;
    JTextField num2Field;
    JTextField resultField;

    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;

    Calculator() {

        setTitle("Simple Calculator");

        setLayout(new FlowLayout());

        // First number
        add(new JLabel("Number 1:"));
        num1Field = new JTextField(10);
        add(num1Field);

        // Second number
        add(new JLabel("Number 2:"));
        num2Field = new JTextField(10);
        add(num2Field);

        // Buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        // Result
        add(new JLabel("Result:"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        add(resultField);

        // Event handling
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setSize(350, 200);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            double result = 0;

            if (e.getSource() == addButton) {

                result = num1 + num2;

            } else if (e.getSource() == subtractButton) {

                result = num1 - num2;

            } else if (e.getSource() == multiplyButton) {

                result = num1 * num2;

            } else if (e.getSource() == divideButton) {

                if (num2 == 0) {
                    resultField.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));

        }
        catch (NumberFormatException ex) {

            resultField.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {

        new Calculator();
    }
}