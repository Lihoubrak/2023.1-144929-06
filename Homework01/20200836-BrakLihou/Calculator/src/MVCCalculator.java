import controller.CalculatorController;
import model.CalculatorModel;
import view.Calculator;

public class MVCCalculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        Calculator view = new Calculator();
        CalculatorController controller = new CalculatorController(view, model);
    }
}
