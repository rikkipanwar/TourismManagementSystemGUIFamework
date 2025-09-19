package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class SignUpPage extends BaseClass {
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "fname")
	private WebElement fullNameEdt;
	
	@FindBy(name = "mobilenumber")
	private WebElement mobNoEdt;
	
	@FindBy(xpath = "//input[@placeholder='Email id']")
	private WebElement emailEdt;
	
	@FindBy(xpath = "//form[@name='signup']/input[@placeholder='Password']")
	private WebElement passwordEdt;
	
	@FindBy(name = "submit")
	private WebElement createAccountBtn;
	
	
	public WebElement getFullNameEdt() {
		return fullNameEdt;
	}

	public WebElement getMobNoEdt() {
		return mobNoEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}

	public void createNewUser(String fName, String mobNum, String email, String password) {
		wLib.waitForElementPresent(driver, getFullNameEdt());
		getFullNameEdt().sendKeys(fName);
		getMobNoEdt().sendKeys(mobNum);
		getEmailEdt().sendKeys(email);
		getPasswordEdt().sendKeys(password);
		getCreateAccountBtn().click();	
	}
}
