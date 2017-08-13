package Calculator;

/*
 * Author: Anthony Schneider
 * File: OperandNode.java
 */
public class OperatorNode implements Node {

    private Node left, right;
    private Operator operator;

    OperatorNode() {

    }

    OperatorNode(Operator operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double leftValue = left.evaluate();
        double rightValue = right.evaluate();
        return operator.evaluate(leftValue, rightValue);
    }

    @Override
    public String inOrderWalk() {
        String leftValue = left.inOrderWalk();
        String rightValue = right.inOrderWalk();
        return "(" + leftValue + " " + operator + " " + rightValue + ")";
    }

    @Override
    public String postOrderWalk() {
        String leftValue = left.postOrderWalk();
        String rightValue = right.postOrderWalk();
        return leftValue + " " + rightValue + " " + operator;
    }
}
