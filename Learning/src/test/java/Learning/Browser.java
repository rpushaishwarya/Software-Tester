package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static void main(String [] args) {
		//Automatically Initilized
		// Automatically setup ChromeDriver
		WebDriverManager.chromedriver().setup();

		// Configure browser options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Start maximized
		options.addArguments("--disable-notifications"); // Disable notifications
		options.addArguments("--headless"); // Run in headless mode

		// Initialize WebDriver with options
		WebDriver driver = new ChromeDriver(options);

		// Open a website - it not store the history 
		driver.get("https://www.example.com");
		
		//It store the history
		driver.navigate().to("https://www.google.com");        
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		//This method fetches the Title of the current page. 
		//Accepts nothing as a parameter and returns a String value.
		String Title= driver.getTitle();
		System.out.println(Title);

		//This method fetches the string representing the Current URL which is opened in the browser. 
		//Accepts nothing as a parameter and returns a String value.
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);

		//This method returns the Source Code of the page. 
		//Accepts nothing as a parameter and returns a String value.
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);


		//Quit the browser if it's the last window currently open.
		driver.close();

		// This method Closes all windows opened by the WebDriver. 
		//Accepts nothing as a parameter and returns nothing.

		driver.quit();

	}

}
