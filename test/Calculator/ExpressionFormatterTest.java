package Calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionFormatterTest {

    @Test
    void formatter() {
        List<String> expression = ExpressionFormatter.formatter("(-3.6*43+(-6.7*-42))");
        List<String> expected = Arrays.asList("(", "-3.6", "*", "43", "+", "(", "-6.7", "*", "-42", ")", ")");
        assertEquals(expected, expression);
        ExpressionFormatter.clear();
        expression = ExpressionFormatter.formatter("-3.4--8");
        expected = Arrays.asList("-3.4", "-", "-8");
        assertEquals(expected, expression);
        ExpressionFormatter.clear();
        expression = ExpressionFormatter.formatter("(8*8)/2");
        expected = Arrays.asList("(", "8", "*", "8", ")", "/", "2");
        assertEquals(expected, expression);
    }
}