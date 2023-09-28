import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorView extends JFrame {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton equalButton;
    private JButton memoryAddButton;
    private JButton memorySubButton;
    private JButton memoryClearButton;

    public CalculatorView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        createUserInterface();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUserInterface() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        displayField = new JTextField();
        displayField.setPreferredSize(new Dimension(250, 30));
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.PLAIN, 18));
        displayField.setBackground(Color.WHITE);
        displayField.setForeground(Color.BLACK);
        displayField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(Color.BLACK);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[4];
        String[] operatorSymbols = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(operatorSymbols[i]);
            operatorButtons[i].setBackground(Color.ORANGE);
            operatorButtons[i].setForeground(Color.WHITE);
            operatorButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(operatorButtons[i]);
        }

        clearButton = new JButton("C");
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));

        equalButton = new JButton("=");
        equalButton.setBackground(Color.GREEN);
        equalButton.setForeground(Color.WHITE);
        equalButton.setFont(new Font("Arial", Font.PLAIN, 18));

        memoryAddButton = new JButton("M+");
        memoryAddButton.setBackground(Color.BLUE);
        memoryAddButton.setForeground(Color.WHITE);
        memoryAddButton.setFont(new Font("Arial", Font.PLAIN, 18));

        memorySubButton = new JButton("M-");
        memorySubButton.setBackground(Color.BLUE);
        memorySubButton.setForeground(Color.WHITE);
        memorySubButton.setFont(new Font("Arial", Font.PLAIN, 18));

        memoryClearButton = new JButton("MC");
        memoryClearButton.setBackground(Color.BLUE);
        memoryClearButton.setForeground(Color.WHITE);
        memoryClearButton.setFont(new Font("Arial", Font.PLAIN, 18));

        buttonPanel.add(clearButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(memoryAddButton);
        buttonPanel.add(memorySubButton);
        buttonPanel.add(memoryClearButton);

        mainPanel.add(displayField, BorderLayout.NORTH);
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
