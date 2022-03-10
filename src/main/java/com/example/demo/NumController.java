package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class NumController {
    @FXML
    private Text output;
    private long num1 = 0;

    private boolean start = true;
    private String operator = "";

    private final Model model = new Model();


    @FXML
    private void num(ActionEvent ev) {
        if (start) {
            output.setText("");
            start = false;
        }
        output.setText(output.getText() + ((Button) ev.getSource()).getText());
    }

    @FXML
    private void processOperator(ActionEvent ev) {
        String value = ((Button) ev.getSource()).getText();
        if (!"=".equalsIgnoreCase(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) return;
            output.setText(String.valueOf(model.calculate(num1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    public static class Model {

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
}