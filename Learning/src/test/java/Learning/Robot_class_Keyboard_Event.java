package Learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_class_Keyboard_Event {
	public static void main(String [] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//	Keyboard methods:
//
//		keyPress(int keycode): This method presses a given key. The parameter keycode is an integer value for the key pressed. For example, to press a key for alphabet A, the value that has to pass is KeyEvent.VK_A i.e., keyPress(KeyEvent.VK_A).
//		KeyEvent is generally a low-level event. In Java AWT, low-level events are events that indicate direct communication from the user like a keypress, key release or a mouse click, drag, move, or release, etc. KeyEvent indicates an event that occurs on pressing, releasing, or typing a key on the component object like a text field.
//		This KeyEvent class has various constant fields like VK_0, VK_1 till VK_9  of type integer. These values are the same as ASCII code for numbers '0' till '9'. Similarly, for alphabets, this class has constant fields like VK_A, VK_B till VK_Z. It also has constant fields for representing special characters like VK_DOLLAR for  "$" key, modifier keys like VK_SHIFT for Shift key, etc.
//		keyRelease(int keycode): This method releases a given key. For Example, the Shift key pressed using the *keyPress(KeyEvent.VK_SHIFT *) method needs to release using the keyRelease (KeyEvent.VK_SHIFT ) method.
//
		//maximize browser
				driver.manage().window().maximize();
				Thread.sleep(2000);
				
				// This will click on Browse button
				WebElement webElement = driver.findElement(By.id("browseFile"));		
				//click  Browse button 
				webElement.sendKeys(Keys.ENTER);
				
				//Create object of Robot class
				Robot robot = new Robot();
				//Code to Enter D1.txt 
				//Press Shify key 
				robot.keyPress(KeyEvent.VK_SHIFT);
				//Press d , it gets typed as upper case D as Shift key is pressed
				robot.keyPress(KeyEvent.VK_D);
				//Release SHIFT key to release upper case effect
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_1);
				robot.keyPress(KeyEvent.VK_PERIOD);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyPress(KeyEvent.VK_X);
				robot.keyPress(KeyEvent.VK_T);
				
				//Press ENTER to close the popup
		        robot.keyPress(KeyEvent.VK_ENTER);  

		        //Wait for 1 sec
		        Thread.sleep(1000);
					 
				//This is just a verification part, accept alert
		        webElement = driver.findElement(By.id("uploadButton"));
				
				webElement.click();				 
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		 
				Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());	       	 
				//Accept the Alert		 
				myAlert.accept();
				//Note: Even though Robot class specifies to follow keyRelease for each keyPress event, Alphabets and numbers don't have any side effects on the next statements. Therefore, generally, users skip the keyRelease event for Alphabets and numbers. On the other hand, all the modifier keys such as SHIFT, ALT, etc. will always have a side effect on the next statements. As a result, it is still mandatory to specify keyRelease for each keyPress event of the modifier keys.

//Just Try commenting out robot.keyRelease(KeyEvent.VK_SHIFT); in the above sample code and run the script. You will notice the file name types as, 'D!.TXT'. It is because the key pressed effect for the SHIFT key gets carried forward to the next typed text and types it in the uppercase.
}
}