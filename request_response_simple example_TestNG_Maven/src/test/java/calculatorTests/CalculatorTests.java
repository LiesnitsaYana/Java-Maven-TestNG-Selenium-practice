package calculatorTests;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import calculator.Calculator;

public class CalculatorTests {

	// add testing methods
	@Test
	public void addPassTest() {
		assertEquals(3, Calculator.add(2, 1));
	}

	@Test(enabled = false)
	public void addFailTest() {
		assertEquals(1, Calculator.add(2, 1));
	}

	// subtract testing method
	@Test
	public void subSoftAssertTest() {
		SoftAssert sa = new SoftAssert();
		int expectedResult = 3;
		Reporter.log("asserting sub method: " + true);
		sa.assertTrue(Calculator.sub(5, 2) == expectedResult);
		sa.assertTrue(Calculator.sub(6, 2) == expectedResult, "The error here: " + expectedResult);
	}

	// multiply testing method with using DataProvider
	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { 
			{ 10 } 
		};
	}

	@Test(dataProvider = "dataProvider")
	public void mulPassTest(int value) {
		assertEquals(Calculator.mul(2, 5), value);
	}

	// divide testing methods with using parameters from xml-file
	@Test
	@Parameters({ "param1", "param2" })
	public void divPassTest(double param1, double param2) {
		assertEquals(Calculator.div(param1, param2), 5.0);
	}

	@Test(enabled = false)
	@Parameters({ "param1", "param3" })
	public void divFailTest(double param1, double param3) {
		SoftAssert sa = new SoftAssert();
		double expectedResult = 5.0;
		Reporter.log("asserting div method: " + true);
		sa.assertTrue(Calculator.div(param1, param3) == expectedResult, "The error here: " + expectedResult);

	}
}
