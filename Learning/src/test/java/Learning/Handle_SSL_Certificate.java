package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
public class Handle_SSL_Certificate {
	public static void main(String [] arsg) {

	/*What is an SSL certificate?
    *SSL(Secure Sockets Layer) is a standard security protocol that establishes a secure connection between the server and the client(browser). The information sent using an SSL certificate is encrypted and ensures that it delivers to the right server. It is a validator to the website's identity and helps to keep hackers at bay.
    *SSL handshake between a client and a server
    *The browser sends the HTTPS request to the server.
    *To prove that the server is trusted, the server sends the SSL certificate to the browser.
    *Now each browser has its own Trusted Certificate Authority(CA) list. The browser verifies the certificate against the trusted CAs to check if the certificate is present and is unexpired, unrevoked, and its common name is valid for the website requested.
    *If all the checks in the step above are correct, the browser trusts the certificate. Additionally, it also leads to creating an encrypted session that happens between the server and the browser.
    *The server and the browser can now send messages to each other in an encrypted format.
*/
		WebDriverManager.chromedriver().setup();
		//Create instance of ChromeOptions Class
		ChromeOptions handlingSSL = new ChromeOptions();

		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);
				
		//Creating instance of Chrome driver by passing reference of ChromeOptions object
		WebDriver driver=new ChromeDriver(handlingSSL);
		//We can use for internet explore and safari browser
		   JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("CertificateWarningController.visitInsecureWebsiteWithTemporaryBypass()");
			
			//Launching the URL
			driver.get("https://expired.badssl.com/");
			System.out.println("The page title is : " +driver.getTitle());
			driver.quit();
}
}