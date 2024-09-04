package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locator {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//To access all these locators, Selenium provides the “By” class, which helps in locating elements within the DOM.  
		//It offers several different methods (some of which are in the image below) like className, cssSelector, id, linkText, name, partialLinkText, taName, and xpath, etc., 
		//which can identify the web elements based on their corresponding locator strategies.

		//1.Id -The ID is one of the fastest and unique ways of locating web elements
		//2.Name- we should always make sure that the name attribute must contain a unique value If multiple elements have the same value of the ‘name’ attribute, then, Selenium will just select the first values in the page which matches the search criteria.

		//3.class name -To identify it successfully, we need to make sure that the class name value that we are using for locating the web element, i.e., web form, is unique, and any other class doesn’t have the same value. If any other class contains the same value as this, then Selenium will select whichever element comes first while scrapping through the web page.
		//4 &5.Linktext & partial linktext -LinkText and partialLinkText both are quite similar in functionality and locate web elements by using the hyperlink texts. We can only use them for elements containing anchor(<a>) tags. Similar to other locator strategies, if multiple hyperlinks with the same texts are present on the page, then Selenium will always choose the first one.
		//  <a id="simpleLink" href="https://www.demoqa.com" target="_blank">Home</a>

		By.linkText("Home");

		By.partialLinkText("Ho");

		//6.TagName - This locator type uses tag names to identify elements in a web page. The tag name is the HTML tag, such as ***input, div, anchor tag, button, etc.
		//The tagName locator returns all the elements from the page that contains a specified tag.

		//7.CSS or Cascading style sheets selector -These days most of the web pages are dynamically designed. Thus its quite challenging to get a unique id, name, or class to locate element. In this type of situation, CSS selectors can be a great alternative as these are way faster compared to another locator strategies.
		//Syntax -css=(HTML Page)[Attribute=Value]  By.cssSelector("input[id= ‘userName’]");

		//8.XPath uses the XML expression to locate an element on the webpage. Similar to CSS selectors, Xpath is quite useful in locating dynamic elements on a webpage. Xpath can access any element present in the webpage even when they have dynamic properties.
		// (//tag_name[@attribute_value])  //input[@id='userName']

		//Xpath
		//XML Path or commonly known as XPath, is a query language for XML documents. It is made of path expression governed by some pre-defined conditions

		//XPath = //tag_name[@Attribute_name = “Value of attribute”]

		//How to locate web elements using Predicates?

		//It will give us the last input node, which is the child of the div node.-    //div/input[last()]	

		//It will provide us with the child node of div. In other words, input present at the second position in the hierarchy. -//div/input[position()='2']	

		//Types of locators

		//Locating a web element using an Absolute XPath.
		// Locating a web element using Relative XPath.

		//Absolute XPath is the direct way of finding the element it starts from the first/root node of the XML/HTML document and goes all the way to the required node following one node at a time.
		//One major disadvantage or limitation of absolute XPath is that if there is any change in any of the elements on the webpage, then the XPath for any subsequent element will change.


		//Relative XPath starts from any node inside the HTML DOM; it need not start from the root node. It beings with a double forward slash.

		//Even if any preceding element changes or removes, it will not affect the Relative XPath.


		//		     What are XPath Functions in Selenium?
		//		    		 XPath Contains() function
		//		    		 XPath Starts-with() function
		//		    		 XPath Text() function
		//		    		 AND & OR operators
		//		    		 What are the XPath Axes in Selenium?
		//		    		 Ancestor Axis
		//		    		 Child Axis
		//		    		 Descendant Axis
		//		    		 Parent Axis
		//		    		 Following Axis
		//		    		 Following sibling Axis
		//		    		 Preceding Axis
		//		    		 XPath Example: Usage of XPath functions and Axes in Selenium


		//1.Xpath Contains() function
		// XPath Contains() is one of the methods used while creating an XPath expression. We can use it if part of the value of any attribute changes dynamically. It can identify any attribute by using its partial value. 
		//                //tag_name[contains(@attribute,'value_of_attribute')]
		//2.XPath Starts-with() function
		//The XPath starts-with() function, as the name suggests, finds the element which has attribute value starting with the specific given character or character sequence
		//This function is quite useful while dealing with dynamic web pages. Imagine an element that has an attribute value that keeps on changing with every page load or page operation. Usually, these dynamic elements have few common starting characters, followed by random dynamic texts. Apart from the dynamic attribute, this can also identify static elements.
		//      //tag_name[starts-with(@attribute,'Part_of_Attribute_value')]

		//3.XPath Text() function
		//This function uses the text of the web element for locating the element on the webpage. This function is quite useful if your element contains the text, for example, labels, which always contain a static text.
		//   //tag_name[text()='Text of the element']

		//4.AND & OR operators
		//The "and " operator is used to combining two different conditions or attributes to identify any element from a webpage using XPath efficiently. For example, if we have two attributes, a and b, we can combine both to uniquely identify an element on the webpage using the "and " operator.
		//   //tag_name[@name = 'Name value' and @id = ‘ID value’]   //tag_name[@name = 'Name value' or @id = ‘ID value’]


		//What are the XPath Axes in Selenium?

		//all the web elements in the XML DOM are related to each other via a hierarchical structure.

		//1.Xpath Ancestor Axis
		//The ancestor axis is used in XPath to select all the parent (and parent of the parent) elements of the current node. It’s beneficial in scenarios where we can identify the node of the child element, but we are not able to recognize its parent or grandparent nodes. For these scenarios, we can take the child node as a reference point, and we can use the “ancestor” axis to recognize its parent node.
		//        //tag[@attribute ='Attribute_Value']//ancestor::parent_node

		//2.XPath Child Axis
		//Child Axis in XPath is used to find all the child nodes of the current node. Contrary to the ancestor axis, the child is quite helpful in locating elements if we can locate the parent element of the required node.
		//       //tag[@attribute ='Attribute_Value']//child::child_node

		//3.XPath Descendant Axis
		//The Descendant Axis is used to access all the children and sub-children of the current node. It is similar to the child axis, but the fundamental difference between descendant and child is; descendant identifies only the children and sub-children of the same node.
		//      //node[attribute='value of attribute']//descendant::attribute    //div[@class= 'custom-control custom-radio custom-control-inline']/descendant::input

		//4.XPath Parent Axis
		//The Parent Axis is similar to the ancestor axis. It recognizes the immediate parent of the current node. The significant difference between parent and ancestor is; ancestor will recognize all upper hierarchical nodes, whereas the parent axis will only locate the immediate parent node.
		//      //tag[@attribute ='Attribute_Value']//ancestor::parent_node

		//5.XPath Following Axis
		//The following axis locates the element after the current node. It marks the current node as the base and finds the required element present in the DOM  after the current node.
		//        //node[attribute='value of attribute']//following::attribute

		//6.XPath Following sibling Axis
		//The Xpath following sibling axis is similar to the following axis. Following-sibling recognizes only sibling nodes, i.e., the nodes on the same level of the current node
		//         //node[attribute='value of attribute']//following-sibling::attribute

		//7.XPath Preceding Axis
		//The preceding axis is used in XPath to select all the nodes present before the current node. We use it when we can recognize any element above the mentioned element.
		//      //node[attribute='value of attribute']//preceding::attribute

		//CSS Selectors

		//CSS Selector syntax is quite similar to the XPath syntax. It can be represented syntactically as follows:

		//node[attribute_name = ‘attribute_value’]

		//What are the different ways to create CSS Selectors?
		//1.Id                   input[id='firstName']  or input#firstname
		//2.Class                textarea[class='form-control']  or  textarea.form-control
		//3.Attribute            textarea[placeholder='Current Address']       
		//4.Sub String
		//5.Combaining Attribute                    textarea#currentAddress[placeholder='Current Address']
		//Combine the Class and other Attributes     textarea.form-control[placeholder='Current Address']
		//locate a web element when one element is the direct parent/child of another element     Parent_locator > child_locator   div>textarea[placeholder='Current Address']
		// locate a web element when the element exists in the hierarchy    Parent CSS locator > Child HTML tag : nth-of-type(index)
		//locate a web element using text strings    input[id^='userN']
		// locate a web element using the Ending text   input[id$='ame']
		// locate a web element using the contains text   input[id*='erNa']


		//Note: Always make sure that your CSS expression points to a unique element. Sometimes choosing a generic CSS Selector may point to several different elements. If this happens, Selenium will always recognize the first element pointed by the CSS locator. Hence the automation script will fail if it's not the required element.



	}


}
