package Week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAssignment {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    ChromeOptions Options=new ChromeOptions();
	    Options.addArguments("disable-notifications");
	    ChromeDriver driver=new ChromeDriver(Options);
	    driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
	    driver.manage().window().maximize();
	    
	    //Simple dialog
	    
	    driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
	    Alert alert1 = driver.switchTo().alert();
	    Thread.sleep(3000);
		alert1.accept();
		WebElement text1 = driver.findElement(By.xpath("//span[@id='simple_result']"));
		System.out.println(text1.getText());
		
		
		//Confirm Dialog
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Thread.sleep(3000);
		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		WebElement text2 = driver.findElement(By.xpath("//span[@id='result']"));
		System.out.println(text2.getText());
		
		//Sweet Alert
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		//Alert alert3=driver.switchTo().alert();
		//alert3.accept();
		
		//Sweet alert
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Thread.sleep(2000);
		Alert alert3=driver.switchTo().alert();
		alert3.accept();
		///////
		WebElement sweetalert = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"));
		Alert sweetalert1=driver.switchTo().alert();
		sweetalert1.dismiss();
		
		//prompt Alert
		WebElement prompt = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']"));
		prompt.click();
		prompt.sendKeys("Aarthy");
		Thread.sleep(2000);
		
		Alert alert4=driver.switchTo().alert();
		alert4.accept();
		//Alert conf
		
		WebElement conf = driver.findElement(By.xpath("//span[text()='Delete']"));
		conf.click();
		Alert conf1=driver.switchTo().alert();
		conf1.accept();
		
		
	}

}
