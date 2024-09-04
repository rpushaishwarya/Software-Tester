package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitMathProvider_1 {
	Intro provider;

	public JunitMathProvider_1(){

		provider = new Intro();
		}
	@Test
	public void add()
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		int firstNumber = 10;
		int secondNumber = 20;
		assertEquals(firstNumber + secondNumber, provider.Add(firstNumber, secondNumber));
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	 @Test
		public void subtract()
		{
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		    int firstNumber = 10;
		    int secondNumber = 20;
			assertEquals(firstNumber - secondNumber, provider.Substract(firstNumber, secondNumber));
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}
//What is Asserts?

	//Asserts mean verifying the values. Assert can be of an Object type, Boolean type, Int type or any data type. It simply verifies the actual value with the expected value and asserts records only the failed scenario.
	//What is '@Test' Annotation?
	//Pay attention to the '@Test' annotation. All the tests in Junit4 has a @Test annotation that should be put on a test method. This helps the Junit framework to identify tests inside a test class.
}
