package Calculator;

/*
 * Author: Anthony Schneider
 * File: OperandNode.java
 * Purpose: OperandNode's implementation of Node.
 */

public class OperandNode implements Node {

    private final double value;

    OperandNode(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String inOrderWalk() {
        return String.valueOf(value);
    }

    @Override
    public String postOrderWalk() {
        return String.valueOf(value);
    }

}
