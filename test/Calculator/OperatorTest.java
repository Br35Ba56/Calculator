package Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    void testPowOperator() {
        Operator powOperator = new PowOperator();
        double result = powOperator.evaluate(2, 2);
        assertEquals(4.0, result);
        assertEquals("^", powOperator.toString());
    }

    @Test
    void testMulOperator() {
        Operator mulOperator = new MulOperator();
        double result = mulOperator.evaluate(2, 3);
        assertEquals(6.0, result);
        assertEquals("*", mulOperator.toString());
    }

    @Test
    void testDivOperator() {
        Operator divOperator = new DivOperator();
        double result = divOperator.evaluate(8, 2);
        assertEquals(4.0, result);
        assertEquals("/", divOperator.toString());
    }

    @Test
    void testAddOperator() {
        Operator addOperator = new AddOperator();
        double result = addOperator.evaluate(5, 3);
        assertEquals(8.0, result);
        assertEquals("+", addOperator.toString());
    }

    @Test
    void testSubOperator() {
        Operator subOperator = new SubOperator();
        double result = subOperator.evaluate(10, 5);
        assertEquals(5.0, result);
        assertEquals("-", subOperator.toString());
    }
}