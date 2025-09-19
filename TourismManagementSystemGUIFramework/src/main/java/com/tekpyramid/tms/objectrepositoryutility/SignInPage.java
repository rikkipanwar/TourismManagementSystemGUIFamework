package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class SignInPage extends BaseClass {
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Forgot password")
	private WebElement forgetPasswordLink;
	
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement emailEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "signin")
	private WebElement signInBtn;

	public WebElement getForgetPasswordLink() {
		return forgetPasswordLink;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public void loginAsUser(String username, String password){
		wLib.waitForElementPresent(driver, getEmailEdt());
		getEmailEdt().sendKeys(username);
		getPasswordEdt().sendKeys(password);
		getSignInBtn().click();
	}

}
