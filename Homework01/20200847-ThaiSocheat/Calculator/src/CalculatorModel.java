public class CalculatorModel {
    private double memoryValue;
    private double currentValue;
    private String operator;

    public CalculatorModel() {
        clear();
    }

    public void clear() {
        currentValue = 0;
        operator = "";
    }

    public void addToMemory(double value) {
        memoryValue += value;
    }

    public void subtractFromMemory(double value) {
        memoryValue -= value;
    }

    public void clearMemory() {
        memoryValue = 0;
    }

    public double getMemoryValue() {
        return memoryValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void appendDigit(String digit) {
        if (operator.equals("0")) {
            operator = digit;
        } else {
            operator += digit;
        }
        currentValue = Double.parseDouble(operator);
    }

    public double calculateResult() {
        double result = currentValue;
        switch (operator) {
            case "+":
                result += currentValue;
                break;
            case "-":
                result -= currentValue;
                break;
            case "*":
                result *= currentValue;
                break;
            case "/":
                if (currentValue != 0) {
                    result /= currentValue;
                }
                break;
        }
        clear(); // Clear operator and set currentValue to the result
        currentValue = result;
        return result;
    }
}
