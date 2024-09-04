package Junit;

public class Intro {
	
	/* What is Unit testing?
Unit testing is a testing methodology where individual units are tested in isolation from other units. This is usually done by developers. A unit can be considered as a class or method inside a class which needs to be tested individually. It is also known as White Box Testing, as developer is able to see the code for the functionality.
	What is Junit?
			To do Unit testing in Java we have an excellent framework called Junit. Junit is a unit testing framework. This framework provides us with the following facilities

			Base classes and Annotations to write unit tests
			Base class support to run tests, TestRunner class.
			Base class and Annotation support to write test suites, @RunWith(Suite.Class)
			And of course reporting of test results. */
	public Intro(){}

	public int Substract(int firstNumber, int secondNumber)
	{
		return (firstNumber - secondNumber);		
	}

	public int Add(int firstNumber, int secondNumber)
	{
		return (firstNumber + secondNumber);
	}

	public int Multiply(int firstNumber, int secondNumber)
	{
		return (firstNumber * secondNumber);
	}

}
