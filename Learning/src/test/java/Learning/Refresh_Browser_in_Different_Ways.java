package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Refresh_Browser_in_Different_Ways {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//1.Refresh command: The most commonly used and simple command for refreshing a webpage.
		driver.navigate().refresh();
//2.SendKeys command: Second most commonly used command for refreshing a webpage. As it is using a send keys method, we must use this on any Text box on a webpage.
		driver.findElement(By.name("s")).sendKeys(Keys.F5);
//3.Get command: This is a tricky one, as it is using another command as an argument to it. If you look carefully, it is just feeding get command with a page URL.
		driver.get(driver.getCurrentUrl());
//4.To command: This command is again using the same above concept. navigate( ).to( ) is feeding with a page URL and an argument.
		driver.navigate().to(driver.getCurrentUrl());
//5.SendKeys command: This is the same SendKeys command but instead of using Key, it is using ASCII code.
		driver.findElement(By.name("s")).sendKeys("\uE035");

	}

}
