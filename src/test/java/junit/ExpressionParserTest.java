package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.siit.BinaryOperator;
import org.siit.StringExpression;
import org.siit.ValidationException;

import java.util.List;

public class ExpressionParserTest {

    @Test
    public void constantTest() {
        StringExpression e = new StringExpression("0");
        Assertions.assertEquals(List.of(0), e.getElements());
    }

    @Test
    public void multiDigitConstantTest() {
        StringExpression e = new StringExpression("76272733");
        Assertions.assertEquals(List.of(76272733), e.getElements());
    }

    @Test
    public void oneBinaryOperandTest() {
        StringExpression e = new StringExpression("1 + 24");
        Assertions.assertEquals(List.of(1, BinaryOperator.ADD, 24), e.getElements());
    }

    @Test
    public void incorrectNumberThrowsException() {

    }

    @Test
    public void incorrectNumberInExpressionThrowsException() {
        Assertions.assertThrows(ValidationException.class, ()-> new StringExpression("1 + abc"));

    }

    @Test
    public void incorrectNumberOfTokensThrowsException() {
    }


    @Test
    public void testOperatorAndMultipleSpaces() {

    }

    @Test
    public void testConstantWithWhitespace() {

    }

}
