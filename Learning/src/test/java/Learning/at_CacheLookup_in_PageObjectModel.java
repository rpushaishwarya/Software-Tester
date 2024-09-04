package Learning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class at_CacheLookup_in_PageObjectModel {
	public static void main(String [] args) {
		//We use @FindBy and @FindAll annotations to mark a WebElement in the Page Object. @CacheLookup is a very important and overlooked annotation that can help us make our tests run faster.
		//@CacheLookup, as the name suggests helps us control when to cache a WebElement and when not to. This annotation, when applied over a WebElement, instructs Selenium to keep a cache of the WebElement instead of searching for the WebElement every time from the WebPage. This helps us save a lot of time.

//Quick review of when Element lookup happens in Page Objects
//Let us first understand when Selenium makes a FindElement call in PageObject model. Whenever you use a WebElement from your Page Object to perform some action a FindElement is triggered to lookup for the latest version of WebElement from the WebPage. This lookup is basically a FindElement REST Request to Browser's Web driver. This lookup is one of the most time-consuming section of your code.
		@FindBy(how = How.NAME, using = "firstname")
		public WebElement firsName;

		@FindBy(how = How.NAME, using = "lastname")
		public WebElement lastName;
		
		//Adds some text to First and Last name text boxes
		//Reads the text from First and Last name text boxes
		
		//(call in another class)
		// Initialize the Page object
		//(classname)PracticeFormPageObject pageObject = PageFactory.initElements(driver, PracticeFormPageObject.class);

		// Write some values to First and Last Name
		pageObject.firsName.sendKeys("Virender"); // A FindBy call is triggered to fetch First Name
		pageObject.lastName.sendKeys("Singh"); // A FindBy call is triggered to fetch Last Name

		// Read values from the Text box.
		pageObject.firsName.getText(); // A FindBy call is triggered to fetch First Name
		pageObject.lastName.getText(); // A FindBy call is triggered to fetch Last Name

		driver.close();
		driver.quit();
		
		//n this test, there will four times when FindBy call will be triggered. This is marked in the code comments. Every statement like this "pageObject.firstName.getText()" are actually two calls
		/*FindBy to find the element
getText to get the text
Both these calls are REST calls to the browser's WebDriver. If you run the above test you should get a log file named: TestLog.txt in the project's root directory. Let us open the text file and see the contents of it, for reference I am adding a trimmed version of the logs here

 */
		@FindBy(how = How.NAME, using = "firstname")
		public WebElement firsName;

		@FindBy(how = How.NAME, using = "firstname")
		@CacheLookup
		public WebElement firsNameCached;
		
		// We will first try to get Text from the WebElement version which is not cached.
		// We will measure the time to perform 1000 getText operations
		long withoutCacheStartTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i ++)
		{
			pageObject.firstName.getText();
		}
		long withoutCacheEndTime = System.currentTimeMillis();
		System.out.println("Time take in seconds Without cache " + ((withoutCacheEndTime - withoutCacheStartTime)/ 1000));

		// Let us now repeat the same process on the cached element and see
		// the amount of time it takes to perform the same operation 1000 times
		long withCacheStartTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i ++)
		{
			pageObject.firsNameCached.getText();
		}
		long withCacheEndTime = System.currentTimeMillis();
		System.out.println("Time take in seconds With cache " + ((withCacheEndTime - withCacheStartTime)/ 1000));

		
		//Time taken in second without out catch :20
		//Time taken in second with catch:10
		
		
		//When to use and when not to use @Cachelookup annotation
/*  Stale Element and Stale Element Exception
Even though it is tempting to use @CacheLookup annotation for every element, it is not suitable for elements that are dynamic in nature. By Dynamic elements, we mean the elements which refresh themselves quite often. For example, a Timer text which continuously changes the value every second. Another example could be a Stock price ticker which changes every few seconds. These elements are not a good candidates for @CacheLookup annotation.

The reason is quite simple, due to the fact that these elements change frequently on the web page, they are not good candidates for caching. Because if we cache one version of an element and it changes a few seconds later then we will get a Stale element exception.

Static elements
@CacheLookup is very useful for the elements that do not change on the web page once loaded. These types of elements constitute a majority of elements on the web page. So for those elements, as they will not change during test execution, we should use the @Cachelookup annotation to improve the test speed.

*/
	}

}
