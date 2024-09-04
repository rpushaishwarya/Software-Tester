package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;


public class FluentWait {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
/* Fluent waits are also called smart waits also. They are called smart primarily because they don't wait for the max time out, specified in the .withTimeout(5000, TimeUnit.MILLISECONDS). Instead, it waits for the time till the condition specified in .until(YourCondition) method becomes true.
 * */
		
//		Wait wait = new FluentWait(WebDriver reference)
//				.withTimeout(timeout, SECONDS)
//				.pollingEvery(timeout, SECONDS)
//				.ignoring(Exception.class);
//
//				WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
//				public WebElement applyy(WebDriver driver) {
//				return driver.findElement(By.id("foo"));
//				}
//				});
//		 //Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver);
		//Specify the timout of the wait
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		//Sepcify polling time
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		//Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class)

		//This is how we specify the condition to wait on.
		//This is what we will explore more in this chapter
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
