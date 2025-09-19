package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class UpdatePackagesPage extends BaseClass{
	
	public UpdatePackagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "packagename") 
	private WebElement packageNameEdt;
	
	@FindBy(id = "packagetype") 
	private WebElement packageTypeEdt;
	
	@FindBy(id = "packagelocation") 
	private WebElement packageLocationEdt;
	
	@FindBy(id = "packageprice") 
	private WebElement packagePriceEdt;
	
	@FindBy(id = "packagefeatures") 
	private WebElement packageFeaturesEdt;
	
	@FindBy(xpath = "//textarea[@name='packagedetails']") 
	private WebElement packageDetailsEdt;
	
	@FindBy(xpath = "//a[text()='Change Image']") 
	private WebElement packageImageBtn;
	
	@FindBy(xpath = "//div/button[@name='submit']")
	private WebElement updateBtn;

	public WebElement getPackageNameEdt() {
		return packageNameEdt;
	}

	public WebElement getPackageTypeEdt() {
		return packageTypeEdt;
	}

	public WebElement getPackageLocationEdt() {
		return packageLocationEdt;
	}

	public WebElement getPackagePriceEdt() {
		return packagePriceEdt;
	}

	public WebElement getPackageFeaturesEdt() {
		return packageFeaturesEdt;
	}

	public WebElement getPackageDetailsEdt() {
		return packageDetailsEdt;
	}

	public WebElement getPackageImageBtn() {
		return packageImageBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void updatePackage(String packageType, String packagePrice) {
		getPackageTypeEdt().sendKeys(packageType);
		getPackagePriceEdt().sendKeys(packagePrice);
		wLib.obscuredElementClick(driver, getUpdateBtn());
	}
	
}
