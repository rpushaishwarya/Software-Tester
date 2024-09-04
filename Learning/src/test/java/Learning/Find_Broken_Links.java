package Learning;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class Find_Broken_Links {
	public static void main(String [] args) {
		//1.What are links on a Web Page?
/* Hyperlinks, usually called links, are those HTML tags/elements on a web page which we use for redirection to another web page. This happens when a user performs a click operation on these hyperlinks. The user can instantly reach the target page by hitting the link, and the link activates. Each link/hyperlink always contains a target or URL, the URL of the page that will open when the link will be clicked. This link should be valid, so we can open the needed page when someone clicks on the mentioned hyperlink.
		2.What are HTTP Status Codes?
A server generates HTTP Status codes in response to the request submitted by the client to the server. There are five types of responses to which we can segregate HTTP  response status codes. The first digit of the status-code is the response type, and the last two digits have different interpretations associated with the status code. There are different HTTP status codes
200 – Valid Link/success
301/302 - Page redirection temporary/permanent
404 – Page not found
400 – Bad request
401 – Unauthorized
500 – Internal Server Error
    3. What are broken links on a Web page?
A broken link, often called a dead link, is any link on a web page that no longer works because there is an underlying issue with the link. When someone clicks on such a link, sometimes an error message is displayed like a page not found. There may not be any error message at all.  These are essentially invalid HTTP requests and have 4xx and 5xx status code. Some common reasons for a broken link on a webpage can be:

The destination web page is down, moved, or no longer exists.
A web page moved without adding a redirect link.
The user entered an improper/misspell URL.
The web page link removed from the website.
With activated firewall settings, also the browser cannot access the destination web page at times.
      4.What are broken images on a Web Page?
There are cases where an image on the web page does not load properly, and we see "Failed to load image" or similar error messages. In such cases, the image is either corrupt or the image is not at the specified path. A broken image on a web page is a link that is associated with the image, and the link is not working. There can be three possible reasons because of which images doesn't show up on web pages:

Firstly, the image file is not located in the same path specified in your <img src " "> tag.
Secondly, the image does not have the same path or filename.
Thirdly, the image file at the location is either corrupt or undergoes damage, or maybe it's not compatible with a specific browser, and rendering fails in that browser only.
Note: Images can be broken on a web page, even if the link is valid on the page. In such a case, the issue is with either the image file itself or the browser's image rendering.
      5.How to find all the links on a Webpage in Selenium?
The hyperlinks are generally implemented on a web page using the HTML Anchor (<a>) tag. So, if you identify and locate all the anchor tags on a web page and then get the corresponding URLs, we will be able to traverse through all the links on the web page.

	*/
	      WebDriver driver = new ChromeDriver();
	      
	      String url="";
	      List<WebElement> allURLs = driver.findElements(By.tagName("a"));
	      System.out.println("Total links on the Wb Page: " + allURLs.size());

	      //We will iterate through the list and will check the elements in the list.
	      Iterator<WebElement> iterator = allURLs.iterator();
	      while (iterator.hasNext()) {
	    	  url = iterator.next().getText();
	    	  System.out.println(url);
	      }
	 //6.How to find broken links in Selenium tests?
	    //Storing the links in a list and traversing through the links
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size());  
	      
	        //checking the links fetched.
	        for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            verifyLinks(url);
	        }
	        
	        driver.quit();
	    }
	    
	    
	    public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	        //7.How to find broken images in Selenium tests?
	     // Storing all elements with img tag in a list of WebElements
	        List<WebElement> images = driver.findElements(By.tagName("img"));
	        System.out.println("Total number of Images on the Page are " + images.size());
	        
	        
	        //checking the links fetched.
	        for(int index=0;index<images.size();index++)
	        {
	            WebElement image= images.get(index);
	            String imageURL= image.getAttribute("src");
	            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
	            verifyLinks(imageURL);
	          
	            //Validate image display using JavaScript executor
	            try {
	                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
	                if (imageDisplayed) {
	                    System.out.println("DISPLAY - OK");
	                }else {
	                     System.out.println("DISPLAY - BROKEN");
	                }
	            } 
	            catch (Exception e) {
	            	System.out.println("Error Occured");
	            }
	        }
	        
	        
	     driver.quit();
	   }
	    
	    public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	}
	

}
