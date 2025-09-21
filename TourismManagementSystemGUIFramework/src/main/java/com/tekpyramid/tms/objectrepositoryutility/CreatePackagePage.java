package com.tekpyramid.tms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekpyramid.tms.basetest.BaseClass;

public class CreatePackagePage extends BaseClass{
	
	public CreatePackagePage(WebDriver driver) {
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
		
		@FindBy(id = "packagedetails") 
		private WebElement packageDetailsEdt;
		
		@FindBy(id = "packageimage") 
		private WebElement packageImageBtn;
		
		@FindBy(xpath = "//div/button[@name='submit']")
		private WebElement createBtn;

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
		
		public WebElement getCreateBtn() {
			return createBtn;
		}
		
		public void createNewPackage(String pName, String pType, String pLoc, String pPrice, String pFeatures, String pDetails, String pImage) {
			getPackageNameEdt().sendKeys(pName);
			getPackageTypeEdt().sendKeys(pType);
			getPackageLocationEdt().sendKeys(pLoc);
			getPackagePriceEdt().sendKeys(pPrice);
			getPackageFeaturesEdt().sendKeys(pFeatures);
			getPackageDetailsEdt().sendKeys(pDetails);
			wLib.elementIntoView(driver, getPackageImageBtn());
			getPackageImageBtn().sendKeys(pImage);
			wLib.waitForElementClickable(driver, getCreateBtn());
			getCreateBtn().click();
			
		}
}
