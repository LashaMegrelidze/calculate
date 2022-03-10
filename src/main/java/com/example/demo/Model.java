package com.example.demo;

public class Model {

    public double calculate(double firstNum, double secondNum, String operator) {
        if (operator.equals("/")) {
            if (secondNum == 0) {
                return 0;
            }
        }
        return switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "/" -> firstNum / secondNum;
            case "*" -> firstNum * secondNum;
            default -> 0;
        };

    }
}
