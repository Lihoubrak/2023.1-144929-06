import controller.CalculatorController;
import model.CalculatorModel;
import view.Calculator;

import java.util.Scanner;

public class MVCCalculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        Calculator view = new Calculator();
        CalculatorController controller = new CalculatorController(view, model);



        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();
        scanner.close();
        System.out.println("Xin chào " + name + "!");
    }
}
