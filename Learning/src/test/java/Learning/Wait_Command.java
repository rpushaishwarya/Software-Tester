package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;


public class Wait_Command {
	public static void main(String [] args) {
		/*Types of wait 
		 * 1.Implicit wait
           2.Explicit wait
           
           Implicit wait
           
           An implicit wait is a condition-less wait command in Selenium. Since it is condition-less, it is applied to all the web elements on the web page.
           
           We can apply implicit wait through three functions:
           
           implicitlyWait()
           pageLoadTimeout()
           setScriptTimeout()
		   */
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/* During implicitlyWait, the WebDriver will poll the DOM for certain specified time units while trying to find any element. If the element is found earlier, the test executes at that point otherwise the WebDriver waits for the specified duration.
           
           The polling time (or polling interval) is the time interval in which Selenium starts searching again after the last failed try. It depends on the type of browser driver you are working on. Some may have 500 milliseconds while some may have 1 second as polling time. The polling time is inbuild in implicitlyWait and there is no way to modify the time interval. But in Fluent wait, you can specify and overwrite the polling interval.
           
           syntax - driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
           The default value of implicit wait is 0. */


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// pageLoadTimeout command waits for the page to load completely for a specified number of seconds. The default value is 0 and a negative value means infinite wait.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  //this is depracated;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
       
		//The setScriptTimeout command waits for the asynchronous parts of the web page to finish loading for a specified number of seconds.
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);  // this is depracated
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		((JavascriptExecutor) driver).executeScript("alert('hello world');");
		wait.until(webDriver -> {
		    ((JavascriptExecutor) webDriver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");
		    return true; });
		
		//The implicit wait is not advised to be mixed up with explicit wait in the test scripts. A test script with both the waits can produce unpredictable behavior due to erroneous timeout durations.


		/*Explicit wait in Selenium
		 * An explicit wait is a conditional wait strategy in Selenium in other words you wait until the condition you specified becomes true or the time duration has elapsed.
		 * Since explicit wait works with a condition, they help in synchronizing the browser, document object model, and the test execution script. Hence, the overall execution results are satisfactory and time-bound.
		 *alertIsPresent()
			elementSelectionStateToBe()
			elementToBeClickable()
			elementToBeSelected()
			frameToBeAvaliableAndSwitchToIt()
			invisibilityOfTheElementLocated()
			invisibilityOfElementWithText()
			presenceOfAllElementsLocatedBy()
			presenceOfElementLocated()
			textToBePresentInElement()
			textToBePresentInElementLocated()
			textToBePresentInElementValue()
			titleIs()
			titleContains()
			visibilityOf()
			visibilityOfAllElements()
			visibilityOfAllElementsLocatedBy()
			visibilityOfElementLocated()
            The above conditions come under two types of explicit wait commands:
             WebDriverWait
             FluentWait
             *WebDriverWait specifies the condition and time for which the WebDriver needs to wait. Practically, WebDriverWait and explicit wait go synonymously as their definitions and usage match perfectly. So if someone asks you to write some explicit wait scripts, it is safe to assume that the required scripts demand WebDriverWait.
             *
*/
		       WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		       
		     //Fluent wait in Selenium

		     //The fluent wait is similar to explicit wait in Selenium with one additional argument of frequency (also known as polling time). The frequency number tells the WebDriver to keep checking for the element at regular intervals and wait till the maximum of "Duration.ofSeconds". This saves execution time. If the element becomes available earlier, we can proceed with our execution and finish quickly.

				FluentWait<WebDriver> wait2 = new FluentWait<>(driver)
				    .withTimeout(Duration.ofSeconds(30))
				    .pollingEvery(Duration.ofSeconds(5))
				    .ignoring(NoSuchElementException.class);
             //FluentWait in Selenium is an important class when we are dealing with AJAX elements. When a user is exploring the website on a slower network, these elements may take more time to load than what they would have taken in lab testing. To play safe, FluentWait helps us mimic such scenarios and produce the best quality web application.

				/*FAQs
				 * Is explicit wait better than implicit wait?
                  The core nature of explicit wait saves time and is not applicable to all the elements. This gives an impression that explicit waits are better and preferred for test creation. However, there are no such proofs and each type of wait has its own relevance.
                  
                 * When to use implicit wait and when to use explicit wait?
                 The implicit wait is applied once for all the elements and the next wait cycle starts once the previous one completes. If such a situation matches your requirement, implicit wait commands are best in such cases. For example, if you want to perform a task only after the complete page loads, you can go ahead with pageLoadTimeout. But this wait should be applied anyways.
                 The explicit wait is conditional in nature. If you want to wait for only a few select elements based on conditions, the explicit wait is the way to go. However, implicit waits used without a solid understanding of scripts can lead to an unnecessarily long time for the completion of scripts.
                 
                 *What is polling in implicit wait?
                 The implicit wait is done until the element is found or the maximum time has elapsed. But for fallbacks, implicit wait in Selenium comes with a feature called polling. With polling, implicit wait keeps searching for the element at regular intervals till the time it finds the element or the maximum time has elapsed.
                 
                 *Which is the best type of Selenium wait?
                  There is no "best" type of Selenium wait when it comes to testing a web application. Different use cases demand different types of wait conditions and therefore ask for appropriate commands.
                  
                  

*/
	}

}
