package kr.jm.utils;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * The Class ExpressionEvaluator.
 */
public class ExpressionEvaluator {

	private ExpressionParser parser = new SpelExpressionParser();

	/**
	 * Eval.
	 *
	 * @param <R>
	 *            the generic type
	 * @param expression
	 *            the expression
	 * @param returnClass
	 *            the return class
	 * @return the r
	 */
	public <R> R eval(String expression, Class<R> returnClass) {
		return parser.parseExpression(expression).getValue(returnClass);
	}
}
