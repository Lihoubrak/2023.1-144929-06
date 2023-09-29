package Calculator;

public class CalculatorModel {
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        double result = 0;
        switch (operator) {
            case "+" :
                result = firstNumber + secondNumber;
                break;
            case "-" :
                result = firstNumber - secondNumber;
                break;
            case "*" :
                result = firstNumber * secondNumber;
                break;
            case "/" :
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    break;
                } else throw new ArithmeticException("Error");
        }
        return result;
    }
}


