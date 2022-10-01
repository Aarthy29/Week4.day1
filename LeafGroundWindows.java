package Week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/window.xhtml");
		// click on Open button
		WebElement open1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
		open1.click();
		System.out.println(open1.getText());
		Set<String> openwindow = new HashSet<String>();
		List<String> openW = new ArrayList<String>(openwindow);
		driver.manage().window().maximize();

		// Switch to another Window use defaultContent() it will get you to the parent
		// window and perform the next action
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		// Multiple Windows
		WebElement openmulti = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
		openmulti.click();
		//System.out.println(openmulti.getText());
		Thread.sleep(5000);
		Set<String> parentWindowHandler = driver.getWindowHandles();
		List<String> parentWindowHandler1 = new ArrayList<String>(parentWindowHandler);
		//driver.findElement(By.xpath("//span[text()='Text Box']/parent::a")).click();
		driver.switchTo().defaultContent();
		driver.manage().window().maximize();

		// get back to parent window
		driver.switchTo().window(parentWindowHandler1.get(0));
		// CloseWindows
		WebElement Closewindow = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
		Closewindow.click();
		//System.out.println(Closewindow.getText());
		Thread.sleep(5000);
		Set<String> Closewindows = driver.getWindowHandles();
		List<String> ClosewindowW1 = new ArrayList<String>(Closewindows);
		driver.switchTo().defaultContent();
		
		// Wait for two tabs to open

		WebElement twotabs = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']"));
		twotabs.click();
		//System.out.println(twotabs.getText());
		Thread.sleep(5000);
		Set<String> tabs = driver.getWindowHandles();
		List<String> tabs1 = new ArrayList<String>(tabs);
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
