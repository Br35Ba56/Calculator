package Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorNodeTest {

    @Test
    void testOperatorNodeEvaluate() {
        Node operatorNode = new OperatorNode(new MulOperator(), new OperandNode(3), new OperandNode(5));
        assertEquals(15.0, operatorNode.evaluate());

        Node mulNode = new OperatorNode(new MulOperator(), new OperandNode(2), new OperandNode(2));
        Node powNode = new OperatorNode(new PowOperator(), new OperandNode(2), mulNode);
        Node rootNode = new OperatorNode(new MulOperator(), new OperandNode(3), powNode);
        assertEquals(48.0, rootNode.evaluate());

        rootNode = new OperatorNode(new MulOperator(), new OperandNode(5.2), new OperandNode(3.2));
        assertEquals(16.64, rootNode.evaluate());
    }

    @Test
    void testOperatorNodePostOrderWalk() {
        Node mulNode = new OperatorNode(new MulOperator(), new OperandNode(2), new OperandNode(2));
        Node powNode = new OperatorNode(new PowOperator(), new OperandNode(2), mulNode);
        Node rootNode = new OperatorNode(new MulOperator(), new OperandNode(3), powNode);
        assertEquals("3.0 2.0 2.0 2.0 * ^ *", rootNode.postOrderWalk());

        Node left = new OperatorNode(new AddOperator(), new OperandNode(-4), new OperandNode(28));
        Node right = new OperatorNode(new MulOperator(), new OperandNode(7), new OperandNode(-4));
        rootNode = new OperatorNode(new DivOperator(), left, right);
        assertEquals("-4.0 28.0 + 7.0 -4.0 * /", rootNode.postOrderWalk());
    }
}