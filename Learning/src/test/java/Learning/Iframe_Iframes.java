package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
public class Iframe_Iframes {
	public static void main(String [] args) {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//To Switch between iFrames we have to use the driver's switchTo().frame command. We can use the switchTo().frame() in three ways:

       //switchTo.frame(int frameNumber): Pass the frame index and driver will switch to that frame.
       //switchTo.frame(string frameNameOrId): Pass the frame element Name or ID and driver will switch to that frame.
       //switchTo.frame(WebElement frameElement): Pass the frame web element and driver will switch to that frame.
		
		//What is a frame index?
        //How to get total number of frames on a webpage?
        //##How to find total number of iFrames on a webpage
		//1.JavaScript
		//2.finding the total number of web elements with a tag name of iFrame.
		
		//By executing a java script
				JavascriptExecutor exe = (JavascriptExecutor) driver;
				Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
				System.out.println("Number of iframes on the page are " + numberOfFrames);

				//By finding all the web elements using iframe tag
				List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
				System.out.println("The total number of iframes are " + iframeElements.size());
				
				driver.switchTo().frame(0); //1.Switch to Frames by Index 
				driver.switchTo().frame("iframe1");		//Switch by frame name
				driver.switchTo().frame("IF1");   		//Switch by frame ID
				WebElement iframeElement = driver.findElement(By.id("IF1"));

				driver.switchTo().frame(iframeElement);//Switch to Frame by WebElement
//Switching back to the Main page from Frame
				//now use the switch command
				driver.switchTo().frame(0);

				//Do all the required tasks in the frame 0
				//Switch back to the main window
				driver.switchTo().defaultContent();
				
		/*What are iframes?
		 * An iframe is a space on the web page that embeds different kinds of media like images, documents, videos inside the main web page.
		 *The full form of the iframe is Inline Frame and is defined using <iframe> tag in HTML.*/
				
	   /*What is the difference between a frame and an iframe?
	    * Frames are the HTML tags that divide the browser's window into multiple parts, where each part can load a separate HTML document.
	    * iframes, as already explained, are inline frames used to embed content from internal/external websites and denoted by the <iframe> tag. 
	    */
			
		//How to automate iframes using Selenium WebDriver?
				 
                //Locate the frame1 heading
                WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));
                
                //Finding the text of the frame1 heading
                String frame1Text=frame1Heading.getText();
                
                //Print the heading
                System.out.println("Text of the frame1 heading is:"+frame1Text);
                //The output of the above code will render "NoSuchElementException " as shown in the below screenshot, because the Selenium WebDriver is unable to find the web element with the mentioned id in the current context.
                //Selenium first needs to switch the context to the *iframe *to access all the web elements inside the iframe. Selenium WebDriver  provides three ways to switch the focus to a specified iframe:


                //switch to immediate parent iframe using method switchTo().parentFrame().
		}
	}


