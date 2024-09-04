package Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTTP_Proxy_Authentication {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/* SOCKS
Lakshay wishes to communicate with Viru over the internet, but a firewall exists on his network between them and Lakshay is not authorized to communicate through it himself. Therefore, he connects to the SOCKS proxy on his network and sends information about the connection he wishes to make to Viru. The SOCKS proxy opens a connection through the firewall and facilitates the communication between Lakshay and Viru.
HTTP
Lakshay wishes to download a web page from Viru, who runs a web server. Lakshay cannot directly connect to Viru's server, as a firewall has been put in place on his network. In order to communicate with the server, Lakshay connects to his network's HTTP proxy. His internet browser communicates with the proxy in exactly the same way it would the target server - it sends a standard HTTP request header. The HTTP proxy reads the request and looks for the Host header. It then connects to the server specified in the header and transmits any data the server replies with back to Lakshay.


*/
		//How to set HTTP Proxy with Username and Password
//Chrome Browser Authentication Window

		driver.get("https://UserName:Password@Example.com");

		//firefox
		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("profileToolsQA");

		WebDriver driver = new FirefoxDriver(myprofile);
		
		//Note: In case your authentication server requires username with domain like "domainuser" you need to add double slash '' to the Url.

//http://localdomain\user:password@example.com
		
		//Internet
		
		//Note: In case your authentication server requires username with domain like "domainuser" you need to add '%5C'  symbol to the Url.

//http://domain%5Cuser:password@example.com
	}

}
