package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Admin Login")
	private WebElement adminLoginLink;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signUpLink;
	
	@FindBy(linkText = "/ Sign In")
	private WebElement signInLink;
	
	@FindBy(linkText = "Tour Packages")
	private WebElement tourPackagesLink;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicyLink;
	
	@FindBy(linkText = "About")
	private WebElement aboutLink;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUseLink;
	
	@FindBy(xpath = "//a[text()=' Enquiry ']")
	private WebElement enquiryLink;
	
	

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getTourPackagesLink() {
		return tourPackagesLink;
	}

	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement getTermsOfUseLink() {
		return termsOfUseLink;
	}

	public WebElement getEnquiryLink() {
		return enquiryLink;
	}

}
