package org.siit;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluate(Expression expression) {
        int result = 0;
        List<Object> elem = expression.getElements();


        if (elem.size() == 1){
            result = (int) elem.get(0);
        }else if (elem.size() == 3){
            result = evalBinary((int) elem.get(0), (int) elem.get(2),
                    (BinaryOperator) elem.get(1));

        }else {
            //TODO: implement case when elem has more than 3 elements
           result =   evalMuti(elem);
        }

        return result;


    }

    private static  int evalMuti(List<Object> elements){


        int value = 0;

//        Character[] tokensChar;
//        tokensChar = (Character[]) elements.toArray();
        Stack<Object> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i =0 ; i < elements.size(); i++){
            if (elements.get(i) instanceof Integer){
            values.push((int)elements.get(i));
            }else if (elements.get(i).equals(BinaryOperator.ADD) ||
                    elements.get(i).equals(BinaryOperator.MULTIPLY) ||
                    elements.get(i).equals(BinaryOperator.SUBTRACT) ||
                    elements.get(i).equals(BinaryOperator.DIVIDE) ||
                    elements.get(i).equals(BinaryOperator.MODULUS)){
                while (!(ops.empty()) && (precedenceLevel((BinaryOperator) elements.get(i)) <= precedenceLevel((BinaryOperator) ops.peek()))){
                    values.push(applyOp((BinaryOperator) ops.pop(), values.pop(), values.pop()));

                }

                ops.push(elements.get(i));
            }


        }

        while (!ops.empty()) {
            values.push(applyOp((BinaryOperator) ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int evalBinary(int op1, int op2, BinaryOperator op) {
        switch (op) {
            case ADD:
                return op1 + op2;
            case SUBTRACT:
                return op1 - op2;
            case MULTIPLY:
                return op1 * op2;
            case DIVIDE:
                return op1 / op2;
            case MODULUS:
                return op1 % op2;
            default:
                throw new ValidationException("Unknown operator: " + op);
        }
    }

    private static int applyOp(BinaryOperator op, int op2 , int op1){
        switch (op){
            case  ADD:
                return op1 + op2;
            case SUBTRACT:
                return op1 - op2;
            case MULTIPLY:
                return op1 * op2;
            case DIVIDE:
                if (op2 == 0){
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return op1 / op2;
        }
        return 0;
    }

    private  static int precedenceLevel(BinaryOperator op) {
        switch (op){
            case ADD:
            case SUBTRACT:
                return 0;
            case DIVIDE:
            case MULTIPLY:
            case MODULUS:
                return 1;
            default:
                throw new IllegalArgumentException("Operator unkown" + op);

        }
    }


}
