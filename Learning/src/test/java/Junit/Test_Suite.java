package Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      JunitMathProvider_1.class,
      JunitMathProvider_2.class
        	})

public class Test_Suite {
	/* Now, let's find out a way to group our tests to create test suites. Test suite is a really important concept, in the sense that it allows us to group multiple tests based on some common criteria. For e.g. you can group all your Database tests together, similarly, all your test specific to a module can be grouped together.
	 * Here we have just declared an empty class, but annotated it with @RunWith(Suite.class) and Suite.SuiteClasses({}). RunWith annotation actually tells the Junit runner that this class (TestSuite) will not use the default Junit runner but will like to delegate the run to the class mentioned in the parameter of @RunWith annotation. So with this in mind, if we look at what we have written @RunWith(Suite.class). It says to the Junit runner that don't run the class with default test runner delegate it to a class called Suite. Suite is a class in the Junit framework which helps us run build test by adding multiple test classes.

*/

}
