package Week4.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriverManager.chromedriver().setup();
    ChromeOptions Options=new ChromeOptions();
    Options.addArguments("disable-notifications");
    ChromeDriver driver=new ChromeDriver(Options);
    driver.get("https://www.leafground.com/frame.xhtml");
    driver.manage().window().maximize();
    
    //First  frame:
    
   WebElement first = driver.findElement(By.xpath("//div[@class='card']/iframe"));
   driver.switchTo().frame(first);
   driver.findElement(By.xpath("//button[@id='Click']")).click();
   
   //switct to parent frame 
   
   driver.switchTo().defaultContent();
   
 //count the Frame
 		//List<WebElement> = driver.findElements(By.xpath("//iframe"));
   
   WebElement count = driver.findElement(By.xpath("//iframe"));
   System.out.println("Total size of frame's in this Page "+count.getSize());	
   
   //driver.switchTo().frame("frame2");
   //third frame
   
   WebElement second = driver.findElement(By.xpath("(//div[@class='card']/iframe)[3]"));
   driver.switchTo().frame(second);
   driver.switchTo().frame("frame2");
   
   //driver.switchTo().frame(second);
   driver.findElement(By.xpath("//button[text()='Click Me']")).click();
   
	}

}
