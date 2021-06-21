package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumCommands extends Common {

	public void browserCommands() {
		initilizeWebDriver();
		navigateTo("https://en-gb.facebook.com/r.php");

		String title = driver.getTitle();
		System.out.println("Title is : "+title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url is : "+currentUrl);
		
		String sourceCode = driver.getPageSource();
		int sourceCodeLength = sourceCode.length();
		System.out.println("Source Code Length is : "+sourceCodeLength);
		
		driver.close();		
	}
	
	public void navigationCommands() {
		initilizeWebDriver();
		navigateTo("https://en-gb.facebook.com/r.php");
		
		//navigate to method'
		driver.navigate().to("https://www.google.co.in/");
		
		//browser back button click
		driver.navigate().back();
		
		//browser forward button click
		driver.navigate().forward();
		
		//browser Refresh 
		driver.navigate().refresh();
	}
	
	public void webElementCommands() {
		initilizeWebDriver();
		navigateTo("https://en-gb.facebook.com/r.php");
		
		//Find WebElement
		WebElement firstNameTextBox = driver.findElement(By.name("firstname"));
		firstNameTextBox.sendKeys("HelloFirstName");
		
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys("ClearedFirstName");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='menu_login_show_link']/input"));
		loginButton.click();
		
		WebElement emailTextBox = driver.findElement(By.id("email"));
		boolean isEmailDisplayed = emailTextBox.isDisplayed();
		System.out.println("isEmailDisplayed : "+isEmailDisplayed);
		
		if(isEmailDisplayed) {
			System.out.println("Email Displayed");
			emailTextBox.sendKeys("value");
			//Enter value into emailTextBox 
		}
		
		//Work Item
		//for password - check for isEnabled
		
		//loginButton.submit();
		
		WebElement femaleRadio = driver.findElement(By.xpath("//label[text()='Female']"));
		String female = femaleRadio.getText();
		System.out.println("femaleRadio text is : "+female);
		
		String tagNameFemal = femaleRadio.getTagName();
		System.out.println("Tag name is : "+tagNameFemal);
		
		
		WebElement submitButton = driver.findElement(By.name("websubmit"));
		String cssValueSubmitButton = submitButton.getCssValue("background-color");
		System.out.println("background color for submit button : "+cssValueSubmitButton);
		
		String TypeAttribute = submitButton.getAttribute("type");
		System.out.println("Type Attribute of submit button is : "+TypeAttribute);
		
		Dimension dimension = submitButton.getSize();
		System.out.println("Height :" + dimension.height + " Width : "+ dimension.width);
		
		Point point = submitButton.getLocation();
		System.out.println("X codinate :" + point.x + " Y codinate : "+ point.y);
		
		
	}
	
	public void CheckBox_Radio_Buttons() {
		initilizeWebDriver();
		navigateTo("https://demo.opencart.com/index.php?route=account/register");
		
		WebElement agreeCheckBox = driver.findElement(By.name("agree"));
		//agreeCheckBox.click();
		boolean isSelected = agreeCheckBox.isSelected();
		if(!isSelected) {
			agreeCheckBox.click();
			System.out.println("Clicked...");
		}
		
	}
	
	public void BrirthdayDropDown() {
		initilizeWebDriver();
		navigateTo("https://en-gb.facebook.com/r.php");
		
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		daySelect.selectByValue("21");
	}
	
	public void WebTables() {
		initilizeWebDriver();
		navigateTo("http://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> headings = driver.findElements(By.xpath("//table/thead/tr/th"));
		for(WebElement heading : headings) {
			System.out.println(heading.getText());
		}
	}
	
			
	public static void main(String[] args) {
		SeleniumCommands sc = new SeleniumCommands();
		sc.WebTables();

	}

}
