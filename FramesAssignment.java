package Week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		String text = driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']")).getText();
		System.out.println(text);

		// Switch to FirstFrame
		WebElement frame11 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame11);
        //entee the text
		driver.findElement(By.xpath("//b[text()='Topic :']/following::input")).sendKeys("Aarthy");
		// Switch to inner frame
		WebElement innerframe = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(innerframe);
		// Click on checkbox
		driver.findElement(By.xpath("//input[@id='a']")).click();
		// Switch to another frame
	    WebElement anotherframe = driver.findElement(By.xpath("//iframe[@id='frame2']"));
	    driver.switchTo().frame(anotherframe);
		//driver.switchTo().frame(2);
		//Click on dropdown 
		
		WebElement ani = driver.findElement(By.className("col-lg-3"));
		Select frame14 = new Select(ani);
		ani.click();
        frame14.selectByIndex(3);

	
	}

}
