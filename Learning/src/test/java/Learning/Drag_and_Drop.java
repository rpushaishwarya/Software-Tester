package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Drag_and_Drop {
	public static void main(String [] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		/*methods Actions class provides for Drag-Drop action:

          dragAndDrop(WebElementsource, WebElement target)
          dragAndDropBy(WebElementsource, int xOffset, int yOffset)*/
		
		//Actions class method to drag and drop		
				Actions builder = new Actions(driver);
				 
				WebElement from = driver.findElement(By.id("draggable"));
				 
				WebElement to = driver.findElement(By.id("droppable"));	 
				//Perform drag and drop
				builder.dragAndDrop(from, to).perform();
				
				//DragAndDropBy action in Selenium using OffSets

				//dragAndDropBy(WebElement source, int xOffset, int yOffset): This method clicks & holds the source element and moves by a given offset, then releases the mouse. Offsets are defined by x & y.

                //xOffset is horizontal movement
                //yOffset is a vertical movement
				//Here, getting x and y offset to drop source object on target object location
				//First, get x and y offset for from object
				int xOffset1 = from.getLocation().getX();
				
				int yOffset1 =  from.getLocation().getY();
				
				System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
				
				//Secondly, get x and y offset for to object
				int xOffset = to.getLocation().getX();
						
				int yOffset =  to.getLocation().getY();
				
				System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);
				
				//Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
				xOffset =(xOffset-xOffset1)+10;
				yOffset=(yOffset-yOffset1)+20;
				

				//Perform dragAndDropBy 
				builder.dragAndDropBy(from, xOffset,yOffset).perform();
				
				//Perform dragAndDropBy 
				builder.dragAndDropBy(from, 100,100).perform();	

	}

}
