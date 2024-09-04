package Junit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class Test_Runner {
	/*Till now we have learned how to write a unit test and run that test. But running a test one by one is a pain and it is not even manageable as in any project there will be many Junit tests. Junits can be in different classes and different methods. To overcome this situation Junits Framework gives the ability to call all the tests from a main[ ] test which is called Test Runner.
	 * Now let's see what a Test Runner class is and how we can use it. Test Runner is a class that runs a test or group of tests. This class is nothing but a class with main[ ] method which calls the JunitCore class of junit framework. JUnitCore class is responsible for running tests. This class contains a method called JUnitCore.RunClasses(Class Testclass)
	 * 
	 * */
	public static void main(String [] args) {
		Result result=JUnitCore.runClasses(JunitMathProvider_1.class);
		System.out.println("Total number of tests " + result.getRunCount());
		System.out.println("Total number of tests failed " + result.getFailureCount());

		for(Failure failure : result.getFailures())
		{			
			System.out.println(failure.getMessage());
		}		
		System.out.println(result.wasSuccessful());
	}
	 
	

}
