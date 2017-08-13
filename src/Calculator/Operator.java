package Calculator;

/*
 * Author: Anthony Schneider
 * File: Operator.java
 * Provides abstract Operator and its child classes.
 */

abstract class Operator {

    abstract double evaluate(double leftValue, double rightValue);

}

class PowOperator extends Operator {

    @Override
    public double evaluate(double leftValue, double rightValue) {
        return Math.pow(leftValue, rightValue);
    }

    @Override
    public String toString() {
        return "^";
    }
}

class AddOperator extends Operator {

    @Override
    public double evaluate(double leftValue, double rightValue) {
        return leftValue + rightValue;
    }

    @Override
    public String toString() {
        return "+";
    }
}

class SubOperator extends Operator {

    @Override
    public double evaluate(double leftValue, double rightValue) {
        return leftValue - rightValue;
    }

    @Override
    public String toString() {
        return "-";
    }
}

class MulOperator extends Operator {

    @Override
    public double evaluate(double leftValue, double rightValue) {
        return leftValue * rightValue;
    }

    @Override
    public String toString() {
        return "*";
    }
}

class DivOperator extends Operator {

    @Override
    public double evaluate(double leftValue, double rightValue) {
        return leftValue / rightValue;
    }

    @Override
    public String toString() {
        return "/";
    }
}

