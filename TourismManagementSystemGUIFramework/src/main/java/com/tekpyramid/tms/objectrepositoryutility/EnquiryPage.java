package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class EnquiryPage extends BaseClass{
	
	public EnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "fname")
	private WebElement fullNameEdt;
	
	@FindBy(xpath = "//input[@placeholder='Valid Email id']")
	private WebElement emailIdEdt;
	
	@FindBy(id = "mobileno")
	private WebElement mobileNoEdt;
	
	@FindBy(id = "subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement descriptionEdt;
	
	@FindBy(name = "submit1")
	private WebElement submitBtn;

	public WebElement getFullNameEdt() {
		return fullNameEdt;
	}

	public WebElement getEmailIdEdt() {
		return emailIdEdt;
	}

	public WebElement getMobileNoEdt() {
		return mobileNoEdt;
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createEnquiry(String fName, String emailId, String mobNo, String subject, String description) {
		getFullNameEdt().sendKeys(fName);
		getEmailIdEdt().sendKeys(emailId);
		getMobileNoEdt().sendKeys(mobNo);
		getSubjectEdt().sendKeys(subject);
		getDescriptionEdt().sendKeys(description);
		wLib.obscuredElementClick(driver, getSubmitBtn());
	}

}
