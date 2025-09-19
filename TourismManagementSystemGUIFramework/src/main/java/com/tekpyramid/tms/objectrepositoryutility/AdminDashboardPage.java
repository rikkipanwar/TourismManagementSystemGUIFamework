package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class AdminDashboardPage extends BaseClass{
	
	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='user-name']/span")
	private WebElement headerAdmin;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement logoutLnk;
	
	@FindBy(xpath = "//span[text()=' Tour Packages']")
	private WebElement tourPackagesLnk;
	
	@FindBy(linkText = "Create")
	private WebElement createLnk;
	
	@FindBy(linkText = "Manage")
	private WebElement manageLnk;

	public WebElement getHeaderAdmin() {
		return headerAdmin;
	}
	
	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getTourPackagesLnk() {
		return tourPackagesLnk;
	}

	public WebElement getCreateLnk() {
		return createLnk;
	}

	public WebElement getManageLnk() {
		return manageLnk;
	}

	public void logoutAdmin() {
		getHeaderAdmin().click();
		getLogoutLnk().click();
	}
}
