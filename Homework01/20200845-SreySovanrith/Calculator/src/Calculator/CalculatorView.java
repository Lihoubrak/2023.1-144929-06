package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalButton;
    private JButton clearButton;

    public CalculatorView(){
        frame = new JFrame("Simple Calculator Using Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 350));
        frame.setLayout(new BorderLayout());
        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,5,5,5));
        numberButtons = new JButton[10];

        // display number button by using loop

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        // display operator
        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (JButton button : operatorButtons) {
            buttonPanel.add(button);
        }
        // display = button
        equalButton = new JButton("=");
        buttonPanel.add(equalButton);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // display clear button
        clearButton = new JButton("C");
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    public void addNumberButtonListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }
    public void addOperatorButtonListener(ActionListener listener) {
        for (JButton button : operatorButtons) {
            button.addActionListener(listener);
        }
    }
    public void addEqualButtonListener(ActionListener listener) {
        equalButton.addActionListener(listener);
    }
    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
    public String getInput(){
        return textField.getText();
    }

    public void setInput(String input){
        textField.setText(input);
    }

    public void setResult(String result) {
        textField.setText(result);
    }
}

