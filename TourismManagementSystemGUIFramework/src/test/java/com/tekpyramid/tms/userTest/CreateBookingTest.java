package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.PackageDetailsPage;
import com.tekpyramid.tms.objectrepositoryutility.SignInPage;
import com.tekpyramid.tms.objectrepositoryutility.UserHomePage;

public class CreateBookingTest extends BaseClass {
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void createBookingTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String USERNAME = eLib.getDataFromExcel("signin", 1, 0);
		String PASSWORD = eLib.getDataFromExcel("signin", 1, 1);
		String PACKAGENAME = eLib.getDataFromExcel("bookpackage", 1, 0);
		String FROMDATE = jLib.getSystemDateddMMyyy();
		String TODATE = jLib.getRequiredDate(5);
		String COMMENT = eLib.getDataFromExcel("bookpackage", 1, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getSignInLink().click();
		
		SignInPage sip = new SignInPage(driver);
		sip.loginAsUser(USERNAME, PASSWORD);
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getTourPackagesLink().click();
		
		WebElement details = driver.findElement(By.xpath("//h4[(text()='Package Name: "+PACKAGENAME+"')]/../following-sibling::div/a[text()='Details']"));
		wLib.obscuredElementClick(driver, details);
		
		PackageDetailsPage pdp = new PackageDetailsPage(driver);
		pdp.bookPackage(FROMDATE, TODATE, COMMENT);
		
		String header = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(header.contains("Booked Successfully")) {
			System.out.println("Booking is successfully created");
		} else {
			System.out.println("Booking is not successfully created");
		}
		
		uhp.getLogoutLnk().click();
		
		
	}

}
