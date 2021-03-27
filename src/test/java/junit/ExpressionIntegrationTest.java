package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.siit.ExpressionEvaluator;
import org.siit.StringExpression;

public class ExpressionIntegrationTest {
	
	@Test
	public void parseAndEvaluate() {
		StringExpression e = new StringExpression(
				"22 / 2 - 1 + 5");
		int result = ExpressionEvaluator.evaluate(e);
		
		Assertions.assertEquals(15, result);
	}
	
}
