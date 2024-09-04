package Learning;

public class AutoIT {
	
	//Need of third party tools in Selenium
   //Selenium is confined to automating browsers, so desktop windows are out of scope. If you are looking to automate workflows that go from browser to desktop and back in Selenium, then a little AutoIt is in order.

//What is AutoIt
//AutoIt v3 is a freeware BASIC-like scripting language designed for automating the Windows GUI and general scripting. It uses a combination of simulated keystrokes, mouse movement and window/control manipulation in order to automate tasks in a way not possible or reliable with other languages (e.g. VBScript and SendKeys). AutoIt is also very small, self-contained and will run on all versions of Windows out-of-the-box with no annoying “runtimes” required!
	private static WebDriver driver = null;
	public static void main(String[] args) throws IOException, InterruptedException {

	    driver = new FirefoxDriver();

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.get("https://www.example.com");

	    Runtime.getRuntime().exec("D:\AutoIt\AutoItTest.exe");

	    Thread.sleep(5000);

	    driver.close();
	    //Main Trick
	   // If in case your script did not work, all you need to do is to call the AutoIt script first before opening the Url. AutoIt script takes few seconds to start, in the meantime your  Selenium script will open the url and it will display the authentication window.

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	 		Runtime.getRuntime().exec("D:\AutoIt\AutoItTest.exe");

	 		driver.get("https://www.example.com");

	 		Thread.sleep(5000); 

	 		driver.close();

	}

}
