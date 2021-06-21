package test;

import org.openqa.selenium.By;

import base.Common;

public class Sample extends Common {

	public static void main(String[] args) {
		new Sample().testSample();
		

	}
	
	public void testSample() {
		initilizeWebDriver();
		navigateTo("file:///C:/MySampleWorks/new.html");
		
		driver.findElement(By.id("email")).sendKeys("Test");
	}

}
