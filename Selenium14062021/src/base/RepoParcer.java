package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class RepoParcer {
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	//Constructor
	public RepoParcer(String fileName)
	{
		try {
			this.RepositoryFile = fileName;
			stream = new FileInputStream(RepositoryFile);
			propertyFile.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String locatorName)
	{
		String locatorProperty = propertyFile.getProperty(locatorName);
		return locatorProperty.toString();
	}

	public By getobjectLocator(String locatorName)
	{
		String locatorProperty = propertyFile.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];

		By locator = null;
		switch(locatorType)
		{
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}

}
