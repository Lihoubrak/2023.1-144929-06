package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton clearButton;
    private JButton equalsButton;

    public Calculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(15);
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            buttonPanel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("C");
        equalsButton = new JButton("=");

        JButton[] operatorButtons = {addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton};
        for (JButton button : operatorButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            buttonPanel.add(button);
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public String getInputText() {
        return inputField.getText();
    }

    public void setInputText(String text) {
        inputField.setText(text);
    }

    public void addNumberButtonListener(int number, ActionListener listener) {
        numberButtons[number].addActionListener(listener);
    }

    public void addOperatorButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
}
