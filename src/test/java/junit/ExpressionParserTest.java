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
        Assertions.assertThrows(ValidationException.class, ()->new StringExpression("1 + 2.5s"));
    }

    @Test
    public void incorrectNumberInExpressionThrowsException() {
        Assertions.assertThrows(ValidationException.class, ()-> new StringExpression("1 + abc"));

    }

    @Test
    public void incorrectNumberOfTokensThrowsException() {
        Assertions.assertThrows(ValidationException.class, ()-> new StringExpression(("1+2+")));
    }


    @Test
    public void testOperatorAndMultipleSpaces() {
        StringExpression o = new StringExpression("2 +  3");
        Assertions.assertEquals(3,  o.getElements().size());
    }

    @Test
    public void testConstantWithWhitespace() {
        // not clear
        // if the test consists of whitespaces within digits  logic of splitting tokens should be reconsidered as
        // implementing a char array of tokens for a better control of handling the input stream
    }

}
