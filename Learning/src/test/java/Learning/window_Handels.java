package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_Handels {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		// window in any browser is the main webpage on which the user is landed after hitting a link/URL. Such a window in Selenium is referred to as the parent window also known as the main window  which opens when the Selenium WebDriver session is created and has all the focus of the WebDriver.

    /* getWindowHandle( ): When a website opens, we need to handle the main window i.e the parent window using driver.getWindowHandle( ); method. With this method, we get a unique ID of the current window which will identify it within this driver instance. This method will return the value of the String type.
      getWindowHandles( ): To handle all opened windows which are the child windows by web driver, we use driver.getWindowHandles( ); method. The windows store in a Set of String type and here we can see the transition from one window to another window in a web application. Its return type is Set <String>.
      switchto(): Using this method we perform switch operation within windows.
      action: This method helps in performing certain actions on the windows.
*/
		//How do we handle child windows in Selenium?

		String mainwindow=driver.getWindowHandle();
		Set<String> allwindow=driver.getWindowHandles();
		Iterator<String> itrator=allwindow.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
         while(itrator.hasNext()) {
        	 String childwindow=itrator.next();
        	 if (!mainwindow.equalsIgnoreCase(childwindow)) {
                 driver.switchTo().window(childwindow);
                 WebElement text = driver.findElement(By.id("sampleHeading"));
                 System.out.println("Heading of child window is " + text.getText());
             }
         }
         
         //How to handle multiple windows in Selenium?
      // To handle all new opened window
         Set<String> s1 = driver.getWindowHandles();
         System.out.println("Child window handle is" + s1);
         Iterator<String> i1 = s1.iterator();

         // Here we will check if child window has other child windows and when child window
         //is the main window it will come out of loop.
           while (i1.hasNext()) {
               String ChildWindow = i1.next();
               if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                   driver.switchTo().window(ChildWindow);
                   driver.close();
                   System.out.println("Child window closed");
                }
            }
           //How do we switch back to the parent window from the child windows in Selenium?
           String mainwindow1 = driver.getWindowHandle();
           Set<String> s11 = driver.getWindowHandles();
           Iterator<String> i11 = s1.iterator();
           
           while (i1.hasNext()) {
               String ChildWindow = i1.next();
                   if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                   driver.switchTo().window(ChildWindow);
                   WebElement text = driver.findElement(By.id("sampleHeading"));
                   System.out.println("Heading of child window is " + text.getText());
                   driver.close();
                   System.out.println("Child window closed");
               }
           }    
     
           //  Switch back to the main window which is the parent window.
           driver.switchTo().window(mainwindow);
           driver.quit();  //to close all windows in Selenium

	}
	
	

}
