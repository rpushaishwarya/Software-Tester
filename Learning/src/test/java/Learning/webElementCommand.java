package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class webElementCommand {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//All interesting operations to do with interacting with a page will be performed through this WebElement Interface.
		driver.get("https://qa.vmeasure.cloud");

		//clear( ) : void - If this element is a text entry element, this will clear the value. 
		//This method accepts nothing as a parameter and returns nothing.

		WebElement webcommand=driver.findElement(By.id(null));

		webcommand.clear();

		//sendKeys(CharSequence... keysToSend ) : void - This simulates typing into an element, which may set its value. This method accepts CharSequence as a parameter and returns nothing.

		webcommand.sendKeys("");
		//***click( ) : void ***- This simulates the clicking of any element. Accepts nothing as a parameter and returns nothing.

		webcommand.click();
		//isDisplayed( ) : boolean - This method determines if an element is currently being displayed or not. This accepts nothing as a parameter but returns a boolean value(true/false).
		boolean a= webcommand.isDisplayed();
		//isEnabled( ) : boolean- This determines if the element currently is Enabled or not? This accepts nothing as a parameter but returns boolean value(true/false).
		boolean b=webcommand.isEnabled();
		//This operation only applies to input elements such as Checkboxes, Select Options, and Radio Buttons. This returns True if the element is currently selected or checked, false otherwise.

		boolean c=webcommand.isSelected();
		//***submit( ) : void- ***This method works well/better than the click() if the current element is a form, or an element within a form. This accepts nothing as a parameter and returns nothing.
		webcommand.submit();
		//getText( ) : String- This method will fetch the visible (i.e. not hidden by CSS) innerText of the element. This accepts nothing as a parameter but returns a String value.

		webcommand.getText();
		//getTagName( ) : String- This method gets the tag name of this element. This accepts nothing as a parameter and returns a String value.
		//This does not return the value of the name attribute but return the tag for e.g. "input" for the element <input name="foo"/>.
		webcommand.getTagName();

		//Color values should be returned as rgba strings, so, for example if the "background-color" property is set as "green" in the HTML source, the returned value will be "rgba(0, 255, 0, 1)".


		webcommand.getCssValue(null);

		//Attributes are Ids, Name, Class extra and using this method you can get the value of the attributes of any given element.


		webcommand.getAttribute(null);
		//Dimension - This method fetch the width and height of the rendered element. 
		//This accepts nothing as a parameter but returns the Dimension object.

		webcommand.getSize();

		// Point - This method locate the location of the element on the page.
		//This accepts nothing as a parameter but returns the Point object.
		webcommand.getLocation();

	}

}
