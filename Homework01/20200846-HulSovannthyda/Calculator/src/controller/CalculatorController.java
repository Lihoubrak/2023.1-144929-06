package controller;

import view.Calculator;
import model.CalculatorModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private Calculator theView;
    private CalculatorModel theModel;

    private boolean isNewInput = true;

    public CalculatorController(Calculator theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addEqualsButtonListener(new CalculateListener());

        for (int i = 0; i < 10; i++) {
            final int number = i;
            this.theView.addNumberButtonListener(number, new NumberButtonListener(number));
        }

        this.theView.addOperatorButtonListener(new OperatorButtonListener());
        this.theView.addClearButtonListener(new ClearButtonListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = theView.getInputText();
            String[] tokens = input.split("[+\\-*/]");
            if (tokens.length != 2) {
                return;
            }

            double operand1 = Double.parseDouble(tokens[0]);
            double operand2 = Double.parseDouble(tokens[1]);
            char operator = input.charAt(tokens[0].length());

            theModel.setOperand1(operand1);
            theModel.setOperand2(operand2);
            theModel.setOperator(operator);

            double result = theModel.performCalculation();
            theView.setInputText(Double.toString(result));

            isNewInput = true;
        }
    }

    class NumberButtonListener implements ActionListener {
        private int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNewInput) {
                theView.setInputText("");
                isNewInput = false;
            }

            String currentInput = theView.getInputText();
            String newInput = currentInput + number;
            theView.setInputText(newInput);
        }
    }

    class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton operatorButton = (JButton) e.getSource();
            String operatorText = operatorButton.getText();

            if (!isNewInput) {
                new CalculateListener().actionPerformed(null);
            }

            theView.setInputText(theView.getInputText() + operatorText);
            isNewInput = false;
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setInputText("");
            isNewInput = true;
        }
    }
}
