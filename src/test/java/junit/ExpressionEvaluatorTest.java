package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.siit.BinaryOperator;
import org.siit.Expression;
import org.siit.ExpressionEvaluator;

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

	}
	
	@Test
	void testFiveConstant() {

	}
	
	@Test
	void testMultiDigitConstant() {

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
