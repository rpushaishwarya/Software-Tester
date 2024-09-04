package Learning;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class Robot_class_Mouse_Event {
	public static void main(String [] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		//Robot Class Mouse Events
//		mousePress(int buttons): This method presses one or more mouse buttons.
//		Here, parameter buttons are the Button mask. Which, in turn, is a combination of one or more mouse button masks.
//
//		Following are standard button masks available for mousePress method :
//
//		InputEvent.BUTTON1_DOWN_MASK :  For mouse left -click
//
//		InputEvent.BUTTON2_DOWN_MASK  : For mouse middle button click.
//
//		InputEvent.BUTTON3_DOWN_MASK : For mouse right-click
//
//		InputEvent.BUTTON1_MASK
//
//		InputEvent.BUTTON2_MASK
//
//		InputEvent.BUTTON3_MASK
//
//		mouseRelease(int buttons): This method releases one or more mouse buttons. For Example, robot.mouseRelease(InputEvent. BUTTON1_DOWN_MASK) will release the left click press of the mouse.
//
//		mouseMove(int x, int y): This method moves the mouse pointer to the given screen position. Here, x is X position, and y is Y position in the coordinates. For Example, the method mouseMove(100, 50) will move the mouse pointer to the x coordinate 100 and y coordinate 50 on the screen.
		Thread.sleep(2000);

		// This will click on Browse button
		WebElement webElement = driver.findElement(By.id("browseFile"));
		webElement.sendKeys("ENTER");

		//Create object of Robot class
		Robot robot = new Robot();
         
		//Find x and y coordinates to pass to mouseMove method 
		//1. Get the size of the current window. 
		//2. Dimension class is similar to java Point class which represents a location in a two-dimensional (x, y) coordinate space. 
		//But here Point point = element.getLocation() method can't be used to find the position 
		//as this is Windows Popup and its locator is not identifiable using browser developer tool 
		Dimension i = driver.manage().window().getSize(); 
		System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight()); 
		//3. Get the height and width of the screen 
		int x = (i.getWidth()/4)+20; 
		int y = (i.getHeight()/10)+50; 
		//4. Now, adjust the x and y coordinates with reference to the Windows popup size on the screen 
		//e.g. On current screen , Windows popup displays on almost 1/4th of the screen . So with reference to the same, file name x and y position is specified. 
		//Note : Please note that coordinates calculated in this sample i.e. x and y may vary as per the screen resolution settings
		robot.mouseMove(x,y); 

		//Clicks Left mouse button
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("Browse button clicked");
		Thread.sleep(2000);

		//Closes the Desktop Windows popup
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Closed the windows popup");
		Thread.sleep(1000);


	}

}
