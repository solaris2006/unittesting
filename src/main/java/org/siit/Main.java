package org.siit;

public class Main {

    public static void main(String[] args) {
        StringExpression expression  = new StringExpression("22 / 2 - 1 + 5");
        int result  = ExpressionEvaluator.evaluate(expression);
        System.out.println(result);
    }
}
