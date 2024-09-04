package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tooltip {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Case One: When the tooltip is available in the 'title' attribute. Here, we can retrieve tooltip from By strategy
		//Case Two: When the tooltip is available in 'div'. Here, we can retrieve tooltip using Actions class methods
		
		//How to capture tooltip in Selenium using getAttribute?
		// Get element for which we need to find tooltip 
				WebElement ageTextBox = driver.findElement(By.id("age"));

				//Get title attribute value 
				String tooltipText = ageTextBox.getAttribute("title"); 
				
				System.out.println("Retrieved tooltip text as :"+tooltipText); 
				
				//Verification if tooltip text is matching expected value 
				if(tooltipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){ 
					System.out.println("Pass : Tooltip matching expected value");
					}
				else{ 
					System.out.println("Fail : Tooltip NOT matching expected value"); 
				} 
				
				//How to capture tooltip in Selenium using Actions Class?
				//Instantiate Action Class 
				Actions actions = new Actions(driver); 
				
				//Retrieve WebElement 
				WebElement element = driver.findElement(By.id("tooltipDemo")); 
				
				// Use action class to mouse hover 
				actions.moveToElement(element).perform(); 
				
				WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext")); 
				
				// To get the tool tip text and assert 
				String toolTipText = toolTip.getText();
				System.out.println("toolTipText-->"+toolTipText); 
				
				//Verification if tooltip text is matching expected value 
				if(toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){ 
					System.out.println("Pass* : Tooltip matching expected value");
				}else{
					System.out.println("Fail : Tooltip NOT matching expected value"); 
				} 
	}

}
