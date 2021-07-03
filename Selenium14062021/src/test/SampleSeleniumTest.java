package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SampleSeleniumTest {

	public static void main(String[] args) {
		myntra();
	}
	
	public static void myntra() {
		//Handling notification using ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Women' and @data-type='navElements'] "))).perform();
		
		driver.findElement(By.xpath("//a[text()='Boots'] ")).click();
		
		//Clicking on the check box
		driver.findElement(By.xpath("//ul[@class='categories-list']//div")).click();
		
	}

}
