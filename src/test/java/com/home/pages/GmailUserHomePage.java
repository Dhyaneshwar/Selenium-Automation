package com.home.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.page.base.HomeBasePage;

public class GmailUserHomePage extends HomeBasePage {

	@FindBy(xpath= "// a[@title='Gmail'][not(@aria-label='Google')]")
	WebElement gmailLogo;

	// Constructor
	public GmailUserHomePage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLogo() {
		if(gmailLogo.isDisplayed())
			return true;
		else 
			return false;
	}
}
