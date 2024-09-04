package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Handle_Ajax_call_Using_JavaScriptExecutor {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/* What is Ajax?
          AJAX is a technique to do an XMLHttpRequest (out of band Http request) from a web page to the server and send/retrieve data to be used on the web page. AJAX stands for Asynchronous Javascript And XML.

          Means: Ajax is way for the client-side browser to communicate with the server (for example: retrieve data from a database) without having to perform a page refresh.
          
          What is JQuery?
          JQuery (website) is a javascript framework that makes working with the DOM easier by building lots of high level functionality that can be used to search and interact with the DOM. Part of the functionality of jQuery implements a high-level interface to do AJAX requests.
          JQuery is a lightweight client side scripting library while AJAX is a combination of technologies used to provide asynchronous data transfer
          JQuery and AJAX are often used in conjunction with each other
          JQuery is primarily used to modify data on the screen dynamically and it uses AJAX to retrieve data that it needs without changing the current state of the displayed page

         Here is a sample code to showcase the handling of AJAX controls using Selenium Webdriver. You can integrate it in your test execution class.

         Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");

 */
		
		
	}

}
