package Learning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

class HeadLess_Browser_Testing {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
//		1.What is a headless browser?
		//A headless browser is a term used to define browser simulation programs that do not have a GUI. 
//2.Why use a headless browser for test execution?
//		Useful in CI pipeline: When we need to execute automated test cases remotely on a server or in any of the build and release pipelines for continuous integration servers like Jenkins, it is not always possible to install real browsers on such remote machines. We can use headless browsers to run automation tests efficiently.
//		Beneficial in web scraping: When you want to write a web scraper or data extractor that needs to visit some websites and collect data, headless browsers are a perfect choice. Because we are not concerned about functionality in these cases, we visit web pages and get the data.
//		Support for multiple browser versions: Sometimes, the tester would like to simulate multiple browser versions on the same machine. In that case, you would want to use a headless browser because most of them support the simulation of different versions of browsers.
//		Faster automation test execution: The performance with a headless browser is better compared to real browser automation. The real browsers like Google Chrome, Firefox, and Internet Explorer take a significant amount of time to load CSS, JavaScript, Images, and open and render HTML. Headless browsers do not require all this to load and will start performing functions without waiting for a page to load completely. When we need to run the regression scripts, in headless browsers, we could save time as there are much faster and can render results quickly.
//		Multi-Tasking: Headless browsers can help you, multi-task.You can use your browser or your machine to do anything else while the tests run in the background. Save hours that we otherwise spend staring at the screen.

		//3.Limitations of headless browser testing
//		Debugging will not be feasible, as the only way to check what's running on the browser is to grab the screenshots and validate the output.
//		Headless browsers don't mimic the exact user behavior, as the page doesn't render precisely with all the dependencies that it will render in an actual browser.
//		Cosmetic bugs like the location of a web element, the color of a web element may get missed while running the tests in headless mode.
	//4.How to run Selenium test cases in headless mode?
//		Running Selenium test cases using HTMLUnitDriver.
//		Running Selenium test cases using a headless Chrome browser.
//		And, Running Selenium test cases using the headless Firefox browser.
//		Running Selenium test cases using a headless Edge browser.
 //5.Running Selenium headless browser tests using HTMLUnitDriver.
//		HtmlUnitDriver is an implementation of Selenium WebDriver based on HtmlUnit, which is a Java-based implementation of a web browser without a GUI. HtmlUnitDriver is currently the fastest and most lightweight implementation of WebDriver. HtmlUnitDriver is a well known headless browser driver and has many advantages -
//
//		Fastest implementation of WebDriver compared to other browsers.
//		HtmlUnitDriver is platform-independent.
//		HtmlUnitDriver supports JavaScript.
		//Also, HtmlUnitDriver allows you to choose other browser versions to run your scripts. You can mention different browser versions of Chrome or Firefox in the HtmlUnitDriver itself.
	
		//How to use HtmlUnitDriver as a headless browser with Selenium?
		//HTMLUnitDriver is available as an external dependency and requires you to add the library explicitly.
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
//The above syntax will construct a new instance with JavaScript disabled, and the default browser version. If your application needs some of the JavaScript functionalities, you can enable the same, 
		//use the constructor HtmlUnitDriver (boolean enable javascript) and set the value as true as shown below
		
		HtmlUnitDriver unitDriver=HtmlUnitDriver(true)
//How to run tests on different browser versions using HtmlUnitDriver?
//HtmlUnitDriver allows you to select the version of the browser that you would like to run your tests. The main supported browsers are Chrome, Firefox, and Internet Explorer.
				HTMLUnitDriver driver = new HTMLUnitDriver(BrowserVersion.Firefox_68);
		//if you want to enable JavaScript in a particular browser version, 
		
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_68,true);

		//Running Selenium headless browser tests using the headless Chrome browser.
		
		ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				ChromeDriver driver2 = new ChromeDriver(options);
       //Running Selenium headless browser tests using the headless Firefox browser.
		        FirefoxOptions options = new FirefoxOptions();
		        options.setHeadless(true);
		   		 WebDriver driver = new FirefoxDriver(options);
	  //Running Selenium headless browser tests using the headless Edge browser.
		   		EdgeOptions edgeOptions =new EdgeOptions();
		   	  edgeOptions.addArguments("headless");
		   	  WebDriver driver= new EdgeDriver(edgeOptions);
	}
	

}
