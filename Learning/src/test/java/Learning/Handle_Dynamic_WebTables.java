package Learning;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Dynamic_WebTables {
	public static void  main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Part 1 - Location of the table in the webpage </html/body/div[1]/div[2]/div/div[2]/article/div/>
		//Part 2 - Table body (data) starts from here <table/tbody/>
		//Part 3 - It says table row 2 and table column 1 <tr[2]/td[1]>
		
		String sRow = "2";

		String sCol = "1";

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/article/div/table/tbody/tr["+sRow+"]/td["+sCol+"]")).getText();
	
		String sColValue = "Licensing";

		//First loop will find the 'ClOCK TWER HOTEL' in the first column
		for (int i=1;i<=3;i++){
			String sValue = null;
			sValue = driver.findElement(By.xpath(".//*[@id='post-2924']/div/table/tbody/tr[1]/th["+i+"]")).getText();
			if(sValue.equalsIgnoreCase(sColValue)){
				
				// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
				for (int j=1;j<=2;j++){
					String sRowValue= driver.findElement(By.xpath(".//*[@id='post-2924']/div/table/tbody/tr["+j+"]/td["+i+"]")).getText();
					System.out.println(sRowValue);
				}
			break;
		}
			//Here we are storing the value from the cell in to the string variable
			String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
			System.out.println(sCellValue);
			
			// Here we are clicking on the link of first row and the last column
			driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();        
			System.out.println("Link has been clicked otherwise an exception would have thrown");
			driver.close();
	}
		//Here we are locating the xpath by passing variables in the xpath
				String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
				System.out.println(sCellValue);
				String sRowValue = "Clock Tower Hotel";
				
				//First loop will find the 'ClOCK TWER HOTEL' in the first column
				for (int i=1;i<=5;i++){
					String sValue = null;
					sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
						if(sValue.equalsIgnoreCase(sRowValue)){
							// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
							for (int j=1;j<=5;j++){
								String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
								System.out.println(sColumnValue);
							}
						break;
						}
					}
				driver.close();
			}
		
	}


