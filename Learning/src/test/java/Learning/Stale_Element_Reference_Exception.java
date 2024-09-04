package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.*;
public class Stale_Element_Reference_Exception {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*1.What is StaleElementReferenceException in Selenium WebDriver?
		 * StaleElementReferenceException in Selenium is quite common with test execution for an environment with frequent changes. The exception implies that an element that was earlier present does not exist anymore on the page. It means that the element has been removed from the DOM of the page. The StaleElementReferenceException pops up when an element that was found using the findElement method cannot be interacted with
		 * 2.How to avoid StaleElementReferenceException?
		 * Solution 1- Refresh the web page
You can try the refresh method on the webpage if you face the StaleElementReferenceException. Once refreshed, try searching the same element again. To do so, you may use the below code-
         *Solution 2- Use the explicit wait
    We can use the Selenium webdriver explicit wait method to overcome the problem of finding an element. Now there can be two ways to use explicit wait-

       Wait until the element is present.
       Wait until the element is refreshed.
       *Solution 3- Use the try-catch statement
The tester may also use the try-catch block to find the element throwing StaleElementReferenceException.

I wont agree to this, if it is stale no matter how many times u try it will remain stale. U dont need the for loop, in catch refresh the page and try finding element again.

Please dont bring the approach from other websites if you yourself do not understand- DONE
        *Solution 4- Using POM
In POM design pattern or while using the principles of Page Factory, we locate an element using the @FindBy annotation. It helps in updating the reference of the web element each time before any action is performed on it. This becomes very useful in eliminating the occurrence of StaleElementReferenceException.

 */
		driver.navigate().refresh(); 
		driver.findElement(By.cssSelector("web element locator")).click();
		
		//Applying explicit wait to the desired web element which would ignore stale element reference exception 
				//and wait until the web element is ready to be clickable 
		 WebElement wait=	new WebDriverWait(driver, Duration.ofSeconds(10))
				.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("element locator")));
				driver.findElement(By.xpath("element locator")).click();
				
				
				WebElement wai=new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("element locator"))));
				driver.findElement(By.xpath("element locator")).click();
				
				try {
					driver.findElement(By.cssSelector("webelement locator")).click(); 
				} catch(StaleElementReferenceException e) { 
					driver.navigate().refresh(); 
					driver.findElement(By.cssSelector("webelement locator")).click(); 
				}
	}

}
