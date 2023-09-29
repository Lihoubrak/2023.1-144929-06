package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.model = model;
        this.view = view;

        view.addNumberButtonListener(new NumberButtonListener());
        view.addOperatorButtonListener(new OperatorButtonListener());
        view.addEqualButtonListener(new EqualButtonListener());
        view.addClearButtonListener(new ClearButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = view.getInput();
            input += e.getActionCommand();
            view.setInput(input);
        }
    }

    class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = e.getActionCommand();
            String input = view.getInput();
            model.setFirstNumber(Double.parseDouble(input));
            model.setOperator(operator);
            view.setInput("");
        }
    }

    class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = view.getInput();
            model.setSecondNumber(Double.parseDouble(input));
            double result = model.calculate();
            view.setResult(String.valueOf(result));
        }
    }
    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setInput("");
        }
    }
}

