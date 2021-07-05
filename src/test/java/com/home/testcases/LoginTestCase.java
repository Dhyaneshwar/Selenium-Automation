package com.home.testcases;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.home.core.base.CoreWebDriverBase;
import com.home.pages.LoginPage;
import com.home.pages.GmailUserHomePage;

import core.home.dataProvider.ExcelReader;
import core.home.dataProvider.PropertyReader;

public class LoginTestCase {

	public static Logger logger = Logger.getLogger(LoginTestCase.class.getName());
	protected static PropertyReader propReader = new PropertyReader();
	SoftAssert softAssert = new SoftAssert();

	LoginPage LoginPage;
	GmailUserHomePage GmailUserHomePage;

	@BeforeTest
	public void setUp(ITestContext context) throws Exception {
		CoreWebDriverBase.loadInitialURL(context);

		LoginPage = new LoginPage();
	}
	
	@DataProvider
	public Object[][] getLoginTestData() throws Exception{
		Object[][] testObjArray = ExcelReader.loadExcel(propReader.getApplicationProperty("LoginTestData"),
				"Sheet1");
		return testObjArray;
	}	
	
	@Test(dataProvider="getLoginTestData", priority=1) 
	public void checkSignIn(Map<String,String> map) throws IOException {
		
		System.out.println("----------checkSignIn method----------");
		String signInHeader=LoginPage.getSignInHeading();
		softAssert.assertTrue(LoginPage.verifyStringValues("Sign in", signInHeader));
		
		String username=LoginPage.getProperty("Username");
		LoginPage.enterUserName(username);

		LoginPage.clickNext();
		
		System.out.println(map);
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void checkProfileId() throws IOException {
		
		String username=LoginPage.getProperty("Username");
		String profileId=LoginPage.getProfileId();
		softAssert.assertTrue(LoginPage.verifyStringValues(username, profileId));
		
		String password=LoginPage.getProperty("Password");
		LoginPage.enterPassword(password);
		
		LoginPage.clickNext();		
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void gmailHomePage() throws Exception {
		
		GmailUserHomePage=new GmailUserHomePage();
		softAssert.assertTrue(GmailUserHomePage.verifyLogo());
		softAssert.assertAll();
	}
	
	@AfterTest
	public void teardown() {
		CoreWebDriverBase.close();
	}

}
