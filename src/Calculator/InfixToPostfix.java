package Calculator;

/*
 * Author: Anthony Schneider
 * File: InfixCalculator.java
 * Purpose: Converts Infix expressions to Postfix expressions.
 */

import java.util.*;

class InfixToPostfix {
    //Shunting yard algorithm
    List<String> infixToPostfix(List<String> expression) {
        Stack<String> operatorStack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (String n : expression) {
            if (isNumber(n)) {
                list.add(n);
            } else if (n.equals("(")) {
                operatorStack.push(n);
            } else if (n.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    list.add(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && operatorPrecedence(n) <= operatorPrecedence(operatorStack.peek())) {
                    list.add(operatorStack.pop());
                }
                operatorStack.push(n);
            }
        }
        while (!operatorStack.isEmpty()) {
            list.add(operatorStack.pop());
        }
        return list;
    }

    private int operatorPrecedence(String operator) {
        switch (operator) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "/":
                return 2;
            case "*":
                return 2;
            case "^":
                return 3;
        }
        return 0;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
