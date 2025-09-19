package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class UserHomePage extends BaseClass{
	

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='sig']")
	private WebElement headerUserName;
	
	@FindBy(linkText = "/ Logout")
	private WebElement logoutLnk;
	
	@FindBy(linkText = "Tour Packages")
	private WebElement tourPackagesLink;

	public WebElement getHeaderUserName() {
		return headerUserName;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	
	public WebElement getTourPackagesLink() {
		return tourPackagesLink;
	}
	
}
