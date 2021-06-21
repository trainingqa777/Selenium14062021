package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	
	public WebDriver driver;

	public static void main(String[] args) {

	}
	
	public void initilizeWebDriver() {
		 driver = new ChromeDriver();
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public static void addition() {
		int c = 10+20;
		System.out.println(c);
	}

}
