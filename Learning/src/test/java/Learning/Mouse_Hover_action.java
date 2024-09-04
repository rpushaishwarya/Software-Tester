package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Mouse_Hover_action {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//A mouse hover is also called as hover. Mouse hover action is basically an action where a user places a mouse over a designated area like a hyperlink. It can cause some event to get triggered.
		//methods Actions class has provided for Mouse Hover action:

		//moveToElement(WebElement target)
		//moveToElement(WebElement target, int xOffset, int yOffset)
//1. How to move the mouse cursor to the middle of the web element?

		//Instantiate Action Class        
		Actions actions = new Actions(driver);
		//Retrieve WebElement 'Music' to perform mouse hover 
		WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
		//Mouse hover menuOption 'Music'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'Music' from Menu");

		//Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
		WebElement subMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Rock')]")); 
		//Mouse hover menuOption 'Rock'
		actions.moveToElement(subMenuOption).perform();
		System.out.println("Done Mouse hover on 'Rock' from Menu");

		//Now , finally, it displays the desired menu list from which required option needs to be selected
		//Now Select 'Alternative' from sub menu which has got displayed on mouse hover of 'Rock'
		WebElement selectMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Alternative')]"));
		selectMenuOption.click();
		System.out.println("Selected 'Alternative' from Menu");
//2. How to move the mouse cursor to an element offset?
		 //Instantiate Action Class        
        Actions action = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover 
    	WebElement slider = driver.findElement(By.id("slider"));
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	action.moveToElement(slider,50,0).perform();
    	slider.click();
    	System.out.println("Moved slider in horizontal directions");
	}


}
