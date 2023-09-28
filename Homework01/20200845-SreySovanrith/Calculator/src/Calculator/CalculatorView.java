package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CalculatorView extends JFrame {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton equalButton;
    private JButton memoryAddButton;
    private JButton memorySubButton;
    private JButton memoryClearButton;

    public CalculatorView(){
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        createUserInterface();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void createUserInterface(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        displayField = new JTextField();
        displayField.setPreferredSize(new Dimension(250,30));
        displayField.setEditable(false);
        mainPanel.add(displayField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4,5,5));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }
        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            buttonPanel.add(operatorButtons[i]);
        }

        clearButton = new JButton("C");
        equalButton = new JButton("=");
        memoryAddButton = new JButton("M+");
        memorySubButton = new JButton("M-");
        memoryClearButton = new JButton("MC");
        buttonPanel.add(clearButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(memoryAddButton);
        buttonPanel.add(memorySubButton);
        buttonPanel.add(memoryClearButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
    public void setDisplayValue(double value) {
        displayField.setText(String.valueOf(value));
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
    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
    public void addEqualButtonListener(ActionListener listener) {
        equalButton.addActionListener(listener);
    }
    public void addMemoryAddButtonListener(ActionListener listener) {
        memoryAddButton.addActionListener(listener);
    }
    public void addMemorySubButtonListener(ActionListener listener) {
        memorySubButton.addActionListener(listener);
    }
    public void addMemoryClearButtonListener(ActionListener listener) {
        memoryClearButton.addActionListener(listener);
    }
}

