package calculator;

public class Calculator {

	public static int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public static int sub(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

	public static int mul(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}

	public static double div(double num1, double num2) {
		double result = num1 / num2;
		if (num2 == 0) {
			throw new IllegalArgumentException("Number can not be divide by 0!");
		}
		return result;
	}
}
