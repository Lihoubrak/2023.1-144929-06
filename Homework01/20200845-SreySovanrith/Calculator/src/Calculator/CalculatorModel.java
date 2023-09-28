package Calculator;

public class CalculatorModel {
    private double memoryValue;
    private double currentValue;
    private String operator;

    public CalculatorModel(){
        memoryValue = 0;
        currentValue = 0;
        operator = "";
    }
    public void clear(){
        currentValue = 0;
        operator = "";
    }
    public void addToMemory(double value){
        memoryValue += value;
    }
    public void subtractFromMemory(double value){
        memoryValue -= value;
    }

    public void clearMemory(){
        memoryValue = 0;
    }
    public double getMemoryValue(){
        return memoryValue;
    }
    public double getCurrentValue() {
        return currentValue;
    }
    public void setOperator(String operator) {
        this.operator = operator;
//        currentValue = Double.parseDouble(operator);
    }
    public void appendDigit(String digit) {
        if(operator.equals("0")) {
            operator = digit;
        } else {
            operator += digit;
        }
        currentValue = Double.parseDouble(operator);
    }
    public double calculateResult () {
        double result = currentValue;
        switch (operator) {
            case "+" :
                result += currentValue;
                break;
            case "-" :
                result -=currentValue;
                break;
            case "*" :
                result *= currentValue;
                break;
            case "/" :
                if (currentValue != 0) {
                    result /= currentValue;
                }
                break;
        }
        currentValue = result;
        operator = "";
        return result;
    }

}


