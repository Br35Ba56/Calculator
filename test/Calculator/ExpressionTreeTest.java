package Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class ExpressionTreeTest {

    @Test
    void testExpressionTreeBuilder() throws Exception {
        Node testTree = new OperatorNode(new AddOperator(), new OperandNode(5), new OperandNode(4));
        Node tree = ExpressionTree.expressionTreeBuilder(Arrays.asList("5", "4", "+"));
        assertEquals(testTree.postOrderWalk(), tree.postOrderWalk());
    }

    @Test
    void testExpressionTreeBuilder2() throws Exception {
        Node left = new OperatorNode(new AddOperator(), new OperandNode(-4), new OperandNode(28));
        Node right = new OperatorNode(new MulOperator(), new OperandNode(7), new OperandNode(-4));
        Node testTree = new OperatorNode(new DivOperator(), left, right);
        Node tree = ExpressionTree.expressionTreeBuilder(Arrays.asList("-4", "28", "+", "7", "-4", "*", "/"));
        assertEquals(testTree.postOrderWalk(), tree.postOrderWalk());
    }

    @Test
    void testExpressionTreeBuilder3() throws Exception {
        Node mulNode = new OperatorNode(new MulOperator(), new OperandNode(2), new OperandNode(2));
        Node powNode = new OperatorNode(new PowOperator(), new OperandNode(2), mulNode);
        Node rootNode = new OperatorNode(new MulOperator(), new OperandNode(3), powNode);
        Node tree = ExpressionTree.expressionTreeBuilder(Arrays.asList("3", "2", "2", "2", "*", "^", "*"));
        assertEquals(rootNode.postOrderWalk(), tree.postOrderWalk());
    }
}