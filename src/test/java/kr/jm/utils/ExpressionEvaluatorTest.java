package kr.jm.utils;

import org.junit.Before;
import org.junit.Test;

public class ExpressionEvaluatorTest {

	String expression1 = "30000000000000000l==30000000000000000l";
	String expression2 = "3.0==3";
	String expression3 = "3 == 4.0";
	String expression4 = "3L != 4L";
	String expression5 = "3 < 4";
	String expression6 = "30 <= 4.000";
	String expression7 = "3 > 4";
	String expression8 = "3 >= 4";
	String expression9 = "10>=0";

	ExpressionEvaluator expressionEvaluator;

	@Before
	public void setUp() throws Exception {
		expressionEvaluator = new ExpressionEvaluator();
	}

	@Test
	public void test() {
		System.out
				.println(expressionEvaluator.eval(expression1, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression2, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression3, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression4, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression5, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression6, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression7, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression8, Boolean.class));
		System.out
				.println(expressionEvaluator.eval(expression9, Boolean.class));
	}

}
