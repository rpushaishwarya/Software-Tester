package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;



public class Action_classes {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//However, there are complex interactions like Drag-n-Drop and Double-click which cannot be done by simple WebElement commands. To handle those types of advance actions we have the Actions class in Selenium.
		//The user-facing API for emulating complex user gestures. Use this class rather than using the Keyboard or Mouse directly.

		//Implements the builder pattern: Builds a CompositeAction containing all actions specified by the method calls.

		//Actions class is a collection of individual Action that you want to perform. For e.g. we may want to perform a mouse click on an element. In this case we are looking at two different Action


		Actions a=new Actions(driver); //WebDriver object to initiate its class.

		//Also, an important thing to bring here is that there is one another class which is called Action Class and it is different from Actions class. Because maybe you have noticed the top blue line in the above screenshot, the build method returns Action class. But then what is Action class and how does it different with Actions Class. Let's have a look.

		//what is action class

		//Did I mention Action Class, actually it is not a class but an Interface.

		//It is only used to represent the single user interaction to perform the series of action items build by Actions class.

		//What is the difference between Actions Class and Action Class in Selenium?
		//Actions is a class that is based on a builder design pattern.  This is a user-facing API for emulating complex user gestures.

		//Whereas Action is an Interface which represents a single user-interaction action. It contains one of the most widely used methods perform().

		//ACtions

		//Generate actions sequence: Complex action is a sequence of multiple actions like in this case sequence of steps are:

		//Pressing Shift Key  - keyDown
		//Sending desired text -sendkeys
		//Releasing Shift key  -keyup

		//A modifier key is a key that modifies the action of another key when the two are pressed together like Shift, Control & Alt.

		//WebElement element = driver.findElement(By strategy to identify element);
		//
		//		actions.keyDown(element, Keys.SHIFT);
		//
		//		actions.sendKeys("TextToBeConvertAndSendInUpperCase");
		//
		//		actions.keyUp(Keys.SHIFT);
		//		
		//		An important thing to note here is that, if you hover over any action class method, you will notice that it returns the Actions class object.
		//This is the beauty of the builder pattern. Which means that all actions can be clubbed together as below:

		//actions.keyDown(element, Keys.SHIFT).sendKeys("TextToBeConvertAndSendInUpperCase").keyUp(Keys.SHIFT);
		//This is the beauty of the builder pattern. Which means that all actions can be clubbed together as below:

		//actions.keyDown(element, Keys.SHIFT).sendKeys("TextToBeConvertAndSendInUpperCase").keyUp(Keys.SHIFT);
		//Action action = actions.build();
		//Perform actions sequence: action.perform();

		//Catch in Actions Class:
		//actions.keyDown(element,Keys.SHIFT).sendKeys(TextToBeConvertAndSendInUpperCase).keyUp(Keys.SHIFT).perform();

		//Methods in Actions class of Selenium

		//Keyboard Events
		//Mouse Events

		//		Different Methods for performing Mouse Events:
		//			click(): Clicks at the current mouse location.
		//			doubleClick(): Performs a double-click at the current mouse location.
		//			contextClick() : Performs a context-click at middle of the given element.
		//			clickAndHold(): Clicks (without releasing) in the middle of the given element.
		//			dragAndDrop(source, target): Click-and-hold at the location of the source element, moves to the location of the target element
		//			dragAndDropBy(source, xOffset, yOffset):  Click-and-hold at the location of the source element, moves by a given offset
		//			moveByOffset(x-offset, y-offset): Moves the mouse from its current position (or 0,0) by the given offset
		//			moveToElement(toElement): Moves the mouse to the middle of the element
		//			release(): Releases the depressed left mouse button at the current mouse location

	}

}
