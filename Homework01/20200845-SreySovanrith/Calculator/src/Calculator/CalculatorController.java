package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model ) {
        this.view = view;
        this.model = model;

        view.addNumberButtonListener(new NumberButtonListener());
        view.addOperatorButtonListener(new OperatorButtonListener());
        view.addClearButtonListener(new ClearButtonListener());
        view.addEqualButtonListener(new EqualButtonListener());
        view.addMemoryAddButtonListener(new MemoryAddButtonListener());
        view.addMemorySubButtonListener(new MemorySubButtonListener());
        view.addMemoryClearButtonListener(new MemoryClearButtonListener());
    }
    class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String digit = e.getActionCommand();
            model.appendDigit(digit);
            view.setDisplayValue(model.getCurrentValue());
        }
    }
    class OperatorButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String operator = e.getActionCommand();
            model.setOperator(operator);
            view.setDisplayValue(model.getCurrentValue());
        }
    }
    class ClearButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            model.clear();
            view.setDisplayValue(0);
        }
    }
    class EqualButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            double result = model.calculateResult();
            view.setDisplayValue(result);
        }
    }
    class MemoryAddButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            model.addToMemory(model.getCurrentValue());
        }
    }
    class MemorySubButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            model.subtractFromMemory(model.getCurrentValue());
        }
    }
    class MemoryClearButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            model.clearMemory();
        }
    }

}

