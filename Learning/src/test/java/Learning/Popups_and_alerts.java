package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popups_and_alerts {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
        /*What are the different types of Alerts/popups?
		While automating any web application, Selenium WebDriver may encounter alerts that can either be application dependant or the Operating system dependant on which the user is working. 
		
		1.Windows/OS Alerts: Window-based alerts are system-generated alerts/popups. The developers invoke the operating system APIs to show these alerts/dialogue-boxes. Handling these alerts in Selenium is a little tricky and beyond the WebDriver's capabilities, as Selenium is an automation testing tool for web applications only, and we need third party utility to automate window based popups.  A few of those utilities are AutoIT and Robot Class in Java. A sample operating system based alert will look as follows and are majorly called Dialog-Boxes:
		
		2.Web/Javascript /Browser-based Alerts: Web/Browser based alerts are primarily called Javascript alerts and are those alerts that are browser dependant. These alerts are majorly called Popups.
		*/

		/*What are the various kinds of alerts provided by Web Applications?
		 * Simple alert: These alerts are just informational alerts and have an OK button on them. Users can click on the OK button after reading the message displayed on the alert box. A simple alert box looks like below:
         *Prompt Alert: In Prompt alerts, some input requirement is there from the user in the form of text needs to enter in the alert box. A prompt alert box is displayed like below, where the user can enter his/her username and press the OK button or Cancel the alert box without entering any details .
         *Confirmation Alert: These alerts get some confirmation from the user in the form of accepting or dismissing the message box. They are different from prompt alerts in a way that the user cannot enter anything as there is no text-box available. Users can only read the message and provide the inputs by pressing the OK/Cancel button.
        */
		
		//How to handle Alerts/popups using Selenium WebDriver?
        //WebDriver always has the focus on the main browser window and will run all the commands on the main browser window only. But, whenever an alert/popup appears, it opens up a new window. So, for handling the Alerts using Selenium WebDriver, the focus need to be shifted to the child windows opened by the Alerts. To switch the control from the parent window to the Alert window, the Selenium WebDriver  provides the following command:
		driver.switchTo().alert();
		//Once we switch the control from the main browser window to the alert window,  we can use the methods provided by  Alert Interface to perform various required actions. For example, accepting the alert, dismissing the alert, getting the text from the alert window, writing some text on the alert window, and so on.
		//Void accept(): This method clicks on the 'OK' button of the alert box.
        driver.switchTo().alert().accept();
        //Void dismiss(): We use this method when the 'Cancel' button clicks in the alert box.
        driver.switchTo().alert().dismiss();
        //String getText(): This method captures the message from the alert box.
        driver.switchTo().alert().getText();
        //Void sendKeys(String stringToSend): This method sends data to the alert box.
        driver.switchTo().alert().sendKeys(null);
		
        //How to handle unexpected Alerts using Selenium WebDriver?
        // If we write direct code(without try-catch) to accept or dismiss the alert, and If the alert does not appear, then our test case will fail to throw any exception in Selenium like timeout Exception. Try catch block can handle both situations.
        try {
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        driver.quit();
		
	}

}
