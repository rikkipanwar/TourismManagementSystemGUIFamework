package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class PackageDetailsPage extends BaseClass{
	
	public PackageDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "datepicker")
	private WebElement fromDateEdt;
	
	@FindBy(id = "datepicker1")
	private WebElement toDateEdt;
	
	@FindBy(name = "comment")
	private WebElement commentEdt;
	
	@FindBy(name = "submit2")
	private WebElement submitBtn;

	public WebElement getFromDateEdt() {
		return fromDateEdt;
	}

	public WebElement getToDateEdt() {
		return toDateEdt;
	}

	public WebElement getCommentEdt() {
		return commentEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void bookPackage(String fromDate, String toDate, String comment) {
		wLib.elementIntoView(driver, getFromDateEdt());
		wLib.calenderPopup(driver, getFromDateEdt(), fromDate);
		wLib.elementIntoView(driver, getToDateEdt());
		wLib.calenderPopup(driver, getToDateEdt(), toDate);
		wLib.waitForElementPresent(driver, getCommentEdt());
		getCommentEdt().sendKeys(comment);
		wLib.obscuredElementClick(driver, getSubmitBtn());
	}

}
