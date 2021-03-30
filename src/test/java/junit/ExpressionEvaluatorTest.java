package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.siit.*;

import java.util.List;

class ExpressionEvaluatorTest {

	// given a list of elements -> should be the result of calling the constructor in StringExpression
	// verify the actual result of the operation

	private Expression mockExpression (List<Object> elements){
		Expression expr = Mockito.mock(Expression.class);
		Mockito.when(expr.getElements()).thenReturn(elements);
		return expr;
	}

	@Test
	void testZeroConstant() {

		Assertions.assertThrows(ValidationException.class, ()-> ExpressionEvaluator.evaluate(new StringExpression("")));
	}

	@Test
	void testFiveConstant() {
		int result = ExpressionEvaluator.evaluate(
				mockExpression(List.of(22, BinaryOperator.DIVIDE, 2, BinaryOperator.SUBTRACT,
						1, BinaryOperator.ADD, 5, BinaryOperator.SUBTRACT, 10)));
		Assertions.assertEquals(5, result);
	}

	@Test
	void testMultiDigitConstant() {
		int result = ExpressionEvaluator.evaluate(
				mockExpression(List.of(21, BinaryOperator.MULTIPLY, 20)));
		Assertions.assertEquals(420, result);
	}
	
	@Test
	void testSimpleAddition() {
		// 1 + 1
		int result = ExpressionEvaluator.evaluate(
				mockExpression(List.of (1, BinaryOperator.ADD, 1)));
		Assertions.assertEquals(2, result);
	}

	//TODO: test -> 1 * 2 ; 1 + 1 + 1
	
}
