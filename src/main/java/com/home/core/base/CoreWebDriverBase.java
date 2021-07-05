package com.home.core.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import core.home.dataProvider.PropertyReader;
import static com.home.utils.Constants.CHROME_DRIVER_PATH;
import static com.home.utils.Constants.FIREFOX_DRIVER_PATH;

public class CoreWebDriverBase {

	protected static WebDriver driver;
	static String sUrl = null;
	protected static PropertyReader propReader = new PropertyReader();

	protected static WebDriver createFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
		driver = new FirefoxDriver();
		return driver;
	}

	protected static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		return driver;
	}

	public synchronized static void loadInitialURL(ITestContext context) throws Exception {
		String sUrl = propReader.getApplicationProperty("URL").trim();

		driver = getCurrentDriver();
		context.setAttribute("driver", driver);

		int implicitWait = Integer.parseInt(propReader.getApplicationProperty("ImplicitWait"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		driver.get(sUrl);
	}

	public synchronized static WebDriver getCurrentDriver() throws IOException {
		String sBrowserName = propReader.getApplicationProperty("browser.type").trim();

		if (driver == null) {
			if (sBrowserName.equalsIgnoreCase("firefox")) {
				driver = createFirefoxDriver();
			} else if (sBrowserName.trim().equalsIgnoreCase("chrome")) {
				driver = createChromeDriver();
			} else {
				System.out.println("Please define the browser type = as firefox or chrome in application.properties");
			}
		}
		return driver;
	}

	public static void close() {
		driver.quit();
	}
}
