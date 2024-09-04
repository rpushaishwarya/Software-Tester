package Learning;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Junit_Test_with_Selenium_WebDriver {
	private static ChromeDriver driver;
 	WebElement element;

 @SuppressWarnings("deprecation")
@BeforeClass
 public static void openBrowser(){
	 WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 

 @Test
 public void valid_UserCredential(){

	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("https://www.store.demoqa.com");	
     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
     driver.findElement(By.id("log")).sendKeys("testuser_3");
     driver.findElement(By.id("pwd")).sendKeys("Test@123");
     driver.findElement(By.id("login")).click();
     try{
		 element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
	 }catch (Exception e){
		}
     Assert.assertNotNull(element);
     //This is a simple test of Log In functionality of our Demo application. But what you can notice in it is try/catch block & assert statement. This try block is to test the presence of the element, if it does not find it the element will remain as null. With that assert statement will verify that the element is not null. The basic rule of assert statement is that they act only on failure. We would be soon writing a complete chapter on Junit Asserts.
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @Test
 public void inValid_UserCredential()
 {
	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("https://www.store.demoqa.com");	
     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
     driver.findElement(By.id("log")).sendKeys("testuser");
     driver.findElement(By.id("pwd")).sendKeys("Test@123");
     driver.findElement(By.id("login")).click();
     try{
		element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
     }catch (Exception e){
		}
     Assert.assertNotNull(element);
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}


