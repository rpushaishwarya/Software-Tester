package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handel_Check_box {
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Apart from "Checked " and "UnChecked", sometimes applications provide a tri-state/intermediate,
		//which we generally use when a neutral answer needs to provide for an option or 
		//which is an auto-selection for a parent when the child checkbox is selected. Based on these, checkboxes  will generally have the following states:
       
		//isSelected(): Checks whether a checkbox is selected or not.
		//isDisplayed(): Checks whether a checkbox displays on the web page or not.
		//isEnabled(): Checks whether a checkbox is enabled or not

		WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isselected=checkBoxElement.isSelected();
        
        boolean isdisplayed=checkBoxElement.isDisplayed();
        
        boolean isenable=checkBoxElement.isEnabled();
        
        if(isselected==false) {
        	checkBoxElement.click();
        }
        
        if(isdisplayed==false) {
        	checkBoxElement.click();
        }
        if(isenable==false) {
        	checkBoxElement.click();
        }
		
	}

}
