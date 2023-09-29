import javax.swing.SwingUtilities;

public class CalculatorMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorView view = new CalculatorView();
            CalculatorModel model = new CalculatorModel();
            CalculatorController controller = new CalculatorController(view, model);
        });
    }
}