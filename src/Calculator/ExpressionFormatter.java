package Calculator;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Anthony Schneider
 * File: PostfixFormatter.java
 * Purpose: This class uses a static method to parse a correctly formatted 
 * postfix string.  Format should be as follows:  Spaces between numbers, spaces
 * not needed between operators.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class ExpressionFormatter {

    private static final List<String> formattedArray = new ArrayList<>();
    private static final StringBuilder numBuilder = new StringBuilder();

    //Custom parsing algorithm. Creates a list representing a formatted expression.
    //iterate through all tokens of the expression
    //  if the first token is a '-', then it is a unary negation operator
    //  else if the token is a number, add it to numBuilder
    //  else if the token is an operator
    //    if it is unary negation operator, add it to the numBuilder
    //    else
    //      if there are numbers in the numBuilder, add them to the list
    //      add the operator token to the list
    //  else if the token is an parenthesis
    //    if there are numbers in the numBuilder, add them to the list
    //    add the parenthesis to the list
    //finally, if there are numbers in the numBuilder, add them to the list.

    static List<String> formatter(String postfixInput) {
        char[] tokens = postfixInput.toCharArray();
        for (int index = 0; index < tokens.length; index++) {
            if (isUnaryNegationOperator(tokens[index], index)) {
                numBuilder.append(tokens[index]);
            } else if (isNumber(tokens[index])) {
                numBuilder.append(tokens[index]);
            } else if (isOperator(tokens[index])) {
                if (isUnaryNegationOperator(tokens[index], tokens[index - 1], index)) {
                    numBuilder.append(tokens[index]);
                } else {
                    addNumberFromBuilder();
                    formattedArray.add(String.valueOf(tokens[index]));
                }
            } else if (isParen(tokens[index])) {
                addNumberFromBuilder();
                formattedArray.add(String.valueOf(tokens[index]));
            }
        }
        addNumberFromBuilder();
        return formattedArray;
    }

    private static void addNumberFromBuilder() {
        if (numBuilder.length() != 0) addNumber();
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '-':
            case '+':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    private static boolean isParen(char c) {
        switch (c) {
            case '(':
            case ')':
                return true;
        }
        return false;
    }

    private static boolean isUnaryNegationOperator(char current, int index) {
        return current == '-' && index == 0;
    }

    private static boolean isUnaryNegationOperator(char current, char prior, int index) {
        return index != 0 && (isOperator(prior) ^ isParen(prior)) && current == '-';
    }

    private static void addNumber() {
        formattedArray.add(numBuilder.toString());
        numBuilder.delete(0, numBuilder.length());
    }

    private static boolean isNumber(char c) {
        if (c == '.') return true;
        try {
            Double.parseDouble(String.valueOf(c));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static void clear() {
        formattedArray.clear();
        numBuilder.delete(0, numBuilder.length());
    }
}
