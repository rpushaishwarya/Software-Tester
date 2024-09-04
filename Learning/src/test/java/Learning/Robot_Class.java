package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class Robot_Class {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Selenium scripts use Robot class for automating the browser and desktop pop-ups, but the exciting thing is this class is not part of org.openqa.selenium package of Web Driver API.

      //It doesn’t reside in Web Driver API; it is part of the Java API awt package.

//Need for Robot class

//		When the user needs to handle alert pop-ups on a webpage, or
//		User needs to enter text on the pop-ups with a combination of modifier keys such as Alt, Shift, etc.
		
		//Here, the pop-ups/alerts are Windows pop-ups instead of Webpage pop-ups.


		//For instance, if you are trying to download Email Attachment, Windows pop-up, 'Save Attachment' prompts to specify Download Location, appears. It is nothing but a native OS pop-up.

//What is a Robot class?

		//As per the class description, this class is used to generate native system input events. This class uses native system events to control the mouse and keyboard.

//		1.Import package: Robot class has to import first, to use.
//
//		import java.awt.Robot;
//
//		2. Instantiate: A robot class object is needed to invoke its methods. So, let’s instantiate the Robot class.
//
//		Robot robot = new Robot();
//
//		3. Invoke method: Now invoke the required method on robot object.
//
//		robot.<required_method>();
		
		//robot.keyPress(keycode);
//		Keyboard methods:
//
//			keyPress(int keycode): This method presses a given key. For Example, keyPress(KeyEvent.VK_SHIFT) method presses ''SHIFT' key
//			keyRelease(int keycode): This method releases a given key. For Example, keyRelease(KeyEvent.VK_SHIFT) method releases ''SHIFT" key
//			Mouse Methods:
//
//			mousePress(int buttons): This method presses one or more mouse buttons.For Example, mousePress(InputEvent.BUTTON1_DOWN_MASK) method is used left click mouse button
//			mouseRelease(int buttons): This method releases one or more mouse buttons. For Example, mouseRelease(InputEvent.BUTTON1_DOWN_MASK) method is used to release the left mouse button click
//			mouseMove(int x, int y): This method moves the mouse pointer to given screen coordinates specified by x and y values. For Example, mouseMove(100, 50) will move the mouse pointer to the x coordinate 100 and y coordinate 50 on the screen.
//		Advantages:
//			Here are some of the benefits:
//
//			It provides control over the Keyboard as well as Mouse events.
//			It offers a way to handle an interaction with Operating system pop-ups support of which is not possible with Selenium Web Driver API.
//			Robot class is especially useful in managing file upload/download actions by interacting with OS pop-ups.
//			It is easy to consume in the java Selenium scripts as this class is part of Java package.
//			Limitations:
//			But methods mentioned above to control Keyboard and Mouse have some limitations also. Consider some of those following limitations while writing automation scripts:
//
//			Most of the methods like mouseMove are dependent on screen resolution, so, the method may perform differently on different screens.
//			This class acts only on the window in focus, so the behavior may differ when multiple windows open.
//			Switching between different frames or windows is difficult with Robot methods.
//

	}

}
