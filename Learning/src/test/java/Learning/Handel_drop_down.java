package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handel_drop_down {
	public static void main(String args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//"org.openqa.selenium.support.ui " package of Selenium WebDriver. You can create an object of the Select class, by-passing the object of the "WebElement" class,
		//which shows the object returned by the corresponding locator of the WebElement.
		Select oSel = new Select(driver.findElement(By.xpath("//*[@id='cars']")));

				if(oSel.isMultiple()){
					
					//Selecting multiple values by index
					oSel.selectByIndex(1);
					oSel.selectByIndex(2);

					//Or selecting by values
					oSel.selectByValue("volvo");
					oSel.selectByValue("audi");

					//Or selecting by visible text
					oSel.selectByVisibleText("Volvo");
					oSel.selectByVisibleText("Opel");
				}	
				
				Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
		        
				// Get all the options of the dropdown
				List<WebElement> options = select.getOptions();
				
				// Get the first selected option of the dropdown
				WebElement firstSelectedOption = select.getFirstSelectedOption();
				
				List<WebElement> selectedOptions = select.getAllSelectedOptions();
				
				
				Select select1 = new Select(driver.findElement(By.id("oldSelectMenu")));

				//Deselect all the options
				select1.deselectAll();
				
				//Deselect first value by index
				select1.deselectByIndex(1);
				
				//Deselect option with value "6"
				select1.deselectByValue("6");
				
				 //Deselect option with text "White"
				select1.deselectByVisibleText("White");



	}

}
