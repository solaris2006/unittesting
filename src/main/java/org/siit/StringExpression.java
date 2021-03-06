package org.siit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringExpression implements Expression  {
	
	private List<Object> elements;
	
	public StringExpression(String expression) {
		elements = new ArrayList<>();

		// 1 + 2 -> {"1", "+", "2"} // 1 +; //empty_string // 1 * 5 // + 1 2
		String[] tokens = expression.split("\\s+");


		if (tokens.length % 2 == 0 || tokens[0].isEmpty()){
			throw new ValidationException("Expression must have an even number of tokens.");
		}else if (tokens.length == 1){
			elements.add(parseNumber(tokens[0]));

		} else if (tokens.length == 3) {
			elements.add(parseNumber(tokens[0]));
			elements.add(parseOperator(tokens[1]));
			elements.add(parseNumber(tokens[2]));
		}else {
		//TODO: implement case when you have more than 3 tokens: 1 + 1 * 2 / 4...
			for (int i = 0 ; i < tokens.length; i++){
				elements.add(i % 2 == 0 ? parseNumber(tokens[i]) : parseOperator(tokens[i]));
			}
		}

	}



	private BinaryOperator parseOperator(String token){

		for (BinaryOperator operator : BinaryOperator.values()){
			if(operator.getSymbol().equals(token)){
				return operator;
			}
		}
		throw new ValidationException( token  + " not a valid operator");

		//return null;
		//throw ValidationException


	}

	private Integer parseNumber  (String number) throws ValidationException{
		//TODO: verify if number is a number; if not -> throw validationException
		try {
			Integer.parseInt(number);
		}catch (RuntimeException e){
			throw new ValidationException("No a valid number");
		}

		return Integer.parseInt(number);

	}

	public List<Object> getElements() {
		return elements;
	}
}
