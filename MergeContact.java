package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//username.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Go to Create Lead page
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a")).click();
		Set<String> parent1 = driver.getWindowHandles();
		List<String> parent = new ArrayList<String>(parent1);
		driver.switchTo().window(parent.get(1));
		//Click on First Resulting Contact
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		WebElement dd = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		System.out.println("From contact no is: "+ dd.getText());
		dd.click();
		Thread.sleep(2000);
		//back to main window
		driver.switchTo().window(parent.get(0));
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::a)[2]")).click();
		Set<String> parentWindowHandler = driver.getWindowHandles();
		List<String> parentWindowHandler1=new ArrayList<String>(parentWindowHandler);
		driver.switchTo().window(parentWindowHandler1.get(1));
		//Click on Second Resulting Contact		
		Thread.sleep(5000);
		WebElement dd3 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a"));
		System.out.println("To contact no is"+dd3.getText());
		dd3.click();
		//back to main window
		driver.switchTo().window(parentWindowHandler1.get(0));
		
		//merge  button:
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Alert  handling
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		String title1 = driver.getTitle();
		System.out.println("Title is "+title1);
		if(title1.contains(title1))
		{
			System.out.println("Title is correct");
		}
		else
		{
			System.out.println("Title is Wrong");

		}
	
		
		
	}
}
