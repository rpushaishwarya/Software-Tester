package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement_and_FindElements {
	public static void main(String []args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//FindElement -interact with WebElements, we first have to find or locate these elements on the webpage. 
		//findElement(): This method uniquely finds a web element on the web page.

		//findElements(): This method finds a list of web elements on the web page.
		WebElement element=driver.findElement(By.id(null));
		//The "By" is a locator or query object and accepts the locator specifier or strategies we discussed above. So if we write the line "driver.findElement( By.)" 
		//then the Eclipse IntelliSense will give the following locator strategies that we can associate with By object.
       // Note: In case there is no matching element found, the findElement command throws NoSuchElementException.
		//But what happens if there are multiple elements matching the criteria provided in the findElement() method? When such a case occurs, 
		//the findElement() method returns the first most element within the web page.
		
		//The command findElements() returns a list of web elements that match the specified criteria, unlike findElement() which returned a unique element. 
		//If there are no matching elements then an empty list returns.
        List<WebElement> elements=driver.findElements(By.id(null));
        



		

	}

}
