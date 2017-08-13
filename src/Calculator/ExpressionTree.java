package Calculator;

/*
 * Author: Anthony Schneider
 * File: ExpressionTree.java
 * Purpose: Parses the postfix formatted Array from InfixToPostFix.java into
 * an expression tree.  
 */

import java.util.List;
import java.util.Stack;

class ExpressionTree {

    /*  Algorithm used to build the expression tree
     *      Start with an empty Stack of TreeNodes.
     *      For each element of that array, moving from left to right:
     *          If the element is an operator:
     *              Create a new TreeNode containing that operator
     *              Pop the first element off exprStack, make it the right child of the new TreeNode
     *              Pop the next element off exprStack, make it the left child of the new TreeNode
     *              Push the new TreeNode you just built onto the exprStack
     *          Otherwise (if the element is an operand):
     *              Create a new TreeNode containing that operand
     *              Push the new TreeNode onto the exprStack
     */

    static Node expressionTreeBuilder(List<String> postfixArray) {
        Stack<Node> exprStack = new Stack<>();
        Node rightNode;
        Node leftNode;
        Node tree = new OperatorNode();
        for (String token : postfixArray) {
            if (token.contains("+") && isNotNumber(token)) {
                rightNode = exprStack.pop();
                leftNode = exprStack.pop();
                tree = new OperatorNode(new AddOperator(), leftNode, rightNode);
                exprStack.push(tree);
            } else if (token.contains("-") && isNotNumber(token)) {
                rightNode = exprStack.pop();
                leftNode = exprStack.pop();
                tree = new OperatorNode(new SubOperator(), leftNode, rightNode);
                exprStack.push(tree);
            } else if (token.contains("*") && isNotNumber(token)) {
                rightNode = exprStack.pop();
                leftNode = exprStack.pop();
                tree = new OperatorNode(new MulOperator(), leftNode, rightNode);
                exprStack.push(tree);
            } else if (token.contains("/") && isNotNumber(token)) {
                rightNode = exprStack.pop();
                leftNode = exprStack.pop();
                tree = new OperatorNode(new DivOperator(), leftNode, rightNode);
                exprStack.push(tree);
            } else if (token.contains("^") && isNotNumber(token)) {
                rightNode = exprStack.pop();
                leftNode = exprStack.pop();
                tree = new OperatorNode(new PowOperator(), leftNode, rightNode);
                exprStack.push(tree);
            } else {
                tree = new OperandNode(Double.parseDouble(token));
                exprStack.push(tree);
            }
        }
        return tree;
    }

    private static boolean isNotNumber(String str) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
