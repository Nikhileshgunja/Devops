package Devops;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Components for the GUI
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;

    // Variables for calculations
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // Frame setup
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLayout(null);

        // Input field
        inputField = new JTextField();
        inputField.setBounds(50, 25, 300, 50);
        inputField.setEditable(false);
        add(inputField);

        // Buttons for numbers and functions
        numberButtons = new JButton[10];
        functionButtons = new JButton[8];

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);

        delButton.setBounds(50, 420, 145, 50);
        clrButton.setBounds(205, 420, 145, 50);
        add(delButton);
        add(clrButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                inputField.setText(inputField.getText() + i);
            }
        }
        if (e.getSource() == decButton) {
            inputField.setText(inputField.getText() + ".");
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '*';
            inputField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(inputField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    break;
            }
            inputField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            inputField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = inputField.getText();
            if (!text.isEmpty()) {
                inputField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}