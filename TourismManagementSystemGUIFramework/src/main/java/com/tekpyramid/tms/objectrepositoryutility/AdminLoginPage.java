package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class AdminLoginPage extends BaseClass{
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernameEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login")
	private WebElement signInBtn;
	
	@FindBy(linkText = "Back to home")
	private WebElement backToHomeLnk;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getBackToHomeLnk() {
		return backToHomeLnk;
	}
	
	public void loginAdmin(String username, String password) {
		getUsernameEdt().sendKeys(username);
		getPasswordEdt().sendKeys(password);
		signInBtn.click();
	}

}
