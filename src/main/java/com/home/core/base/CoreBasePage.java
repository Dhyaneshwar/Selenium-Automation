package com.home.core.base;

import java.io.IOException;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import core.home.dataProvider.PropertyReader;

public class CoreBasePage {
	
	protected static WebDriver driver;
	PropertyReader propertyReader = new PropertyReader();
	public static Logger logger = Logger.getLogger(CoreBasePage.class.getName());
	SoftAssert softAssertion= new SoftAssert();
	WebDriverWait explicitWait;
   	
	public CoreBasePage(WebDriver driver) throws IOException {
		CoreBasePage.driver = driver;
		int explicitWaitTime = Integer.parseInt(propertyReader.getApplicationProperty("ExplicitWait"));
		explicitWait = new WebDriverWait(driver, explicitWaitTime);
	}
	
	public String getProperty(String propertyName) throws IOException {
		String propertyValue = propertyReader.getApplicationProperty(propertyName);
		return propertyValue;
	}
}
