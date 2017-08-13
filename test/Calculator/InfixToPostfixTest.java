package Calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {
    @Test
    void testInfixToPost() {
        List<String> infixExpression = Arrays.asList("(", "3", "*", "8", ")");
        List<String> postfixExpression = new InfixToPostfix().infixToPostfix(infixExpression);
        List<String> expectedExpression = Arrays.asList("3", "8", "*");
        assertEquals(expectedExpression.toString(), postfixExpression.toString());

        infixExpression = Arrays.asList("(", "3", "^", "(", "2", "*", "1", ")", ")");
        postfixExpression = new InfixToPostfix().infixToPostfix(infixExpression);
        expectedExpression = Arrays.asList("3", "2", "1", "*", "^");
        assertEquals(expectedExpression.toString(), postfixExpression.toString());
    }


}