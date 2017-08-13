package Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandNodeTest {
    @Test
    void evaluate() {
        OperandNode node = new OperandNode(4);
        assertEquals(4.0, node.evaluate());
    }

    @Test
    void inOrderWalk() {
        OperandNode node = new OperandNode(4);
        assertEquals("4.0", node.inOrderWalk());
    }

    @Test
    void postOrderWalk() {
        OperandNode node = new OperandNode(4);
        assertEquals("4.0", node.postOrderWalk());
    }

}