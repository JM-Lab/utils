package kr.jm.utils;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionEvaluator {

	private ExpressionParser parser = new SpelExpressionParser();

	public <R> R eval(String expression, Class<R> returnClass) {
		return parser.parseExpression(expression).getValue(returnClass);
	}
}
