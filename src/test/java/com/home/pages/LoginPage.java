package com.home.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.page.base.HomeBasePage;

public class LoginPage extends HomeBasePage{

	@FindBy(id="headingText")
	WebElement signInHeading;
	
	@FindBy(id="identifierId")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="profileIdentifier")
	WebElement profileIdentifier;

	@FindBy(xpath="//*[@type='button']//span[text()='Next']")
	WebElement nextBtn;

	//Constructor
	public LoginPage() throws Exception {
		super();
		
		PageFactory.initElements(driver, this);
	}
	
	//Test Methods
	public String getSignInHeading() {
		String signIn=signInHeading.getText();
		return signIn;		
	}
	
	public void enterUserName(String value) {
		username.sendKeys(value);
	}
	
	public void enterPassword(String value) {
		password.sendKeys(value);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public String getProfileId() {
		String profileId=profileIdentifier.getText();
		return profileId;		
	}

	public GmailUserHomePage moveToHomePage() throws Exception {
		return (new GmailUserHomePage());
	}
}
