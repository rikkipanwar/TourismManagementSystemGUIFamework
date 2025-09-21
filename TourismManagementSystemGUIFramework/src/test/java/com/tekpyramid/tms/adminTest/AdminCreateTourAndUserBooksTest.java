package com.tekpyramid.tms.adminTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.AdminDashboardPage;
import com.tekpyramid.tms.objectrepositoryutility.AdminLoginPage;
import com.tekpyramid.tms.objectrepositoryutility.CreatePackagePage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.PackageDetailsPage;
import com.tekpyramid.tms.objectrepositoryutility.SignInPage;
import com.tekpyramid.tms.objectrepositoryutility.UserHomePage;

public class AdminCreateTourAndUserBooksTest extends BaseClass {
	
	@Test(groups = "endToEnd" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void adminCreateTourUserBooksAndAdminConfirmTest() throws IOException {
		String expectedMsg = "Package Created Successfully";
		
		String USERNAME = fLib.getDataFromPropertyFile("admin_username");
		String PASSWORD = fLib.getDataFromPropertyFile("admin_password");
		
		String PACKAGENAME = eLib.getDataFromExcel("packages", 1, 0) + jLib.getRandomNumber();
		String PACKAGETYPE = eLib.getDataFromExcel("packages", 1, 1);
		String PACKAGELOC = eLib.getDataFromExcel("packages", 1, 2);
		String PACKAGEPRICE = eLib.getDataFromExcel("packages", 1, 3);
		String PACKAGEFEATURES = eLib.getDataFromExcel("packages", 1, 4);
		String PACKAGEDETAILS = eLib.getDataFromExcel("packages", 1, 5);
		String PACKAGEIMAGE = eLib.getDataFromExcel("packages", 1, 6);
		
		HomePage hp = new HomePage(driver);
		hp.getAdminLoginLink().click();;
		
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginAdmin(USERNAME, PASSWORD);
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getTourPackagesLnk().click();
		adp.getCreateLnk().click();
		
		CreatePackagePage cpp = new CreatePackagePage(driver);
		cpp.createNewPackage(PACKAGENAME, PACKAGETYPE, PACKAGELOC, PACKAGEPRICE, PACKAGEFEATURES, PACKAGEDETAILS, PACKAGEIMAGE);
		
		String actualMsg = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		try {
	        Assert.assertTrue(actualMsg.contains(expectedMsg), "Package is not successfully created");
	        UtilityClassObject.getTest().log(Status.PASS, "Package is successfully created");
	    } catch (AssertionError e) {
	        UtilityClassObject.getTest().log(Status.FAIL, e.getMessage());
	        throw e;
	    }
		
		adp.logoutAdmin();
		alp.getBackToHomeLnk().click();
		
		String expectedMsg1 = "Booked Successfully";
		
		String USERNAME1 = eLib.getDataFromExcel("signin", 1, 0);
		String PASSWORD1 = eLib.getDataFromExcel("signin", 1, 1);
		String PACKAGENAME1 = PACKAGENAME;
		String FROMDATE = jLib.getSystemDateddMMyyy();
		String TODATE = jLib.getRequiredDate(5);
		String COMMENT = eLib.getDataFromExcel("bookpackage", 1, 3);
		
		HomePage hp1 = new HomePage(driver);
		hp1.getSignInLink().click();
		
		SignInPage sip = new SignInPage(driver);
		sip.loginAsUser(USERNAME1, PASSWORD1);
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getTourPackagesLink().click();
		
		WebElement details = driver.findElement(By.xpath("//h4[(text()='Package Name: "+PACKAGENAME1+"')]/../following-sibling::div/a[text()='Details']"));
		wLib.obscuredElementClick(driver, details);
		
		PackageDetailsPage pdp = new PackageDetailsPage(driver);
		pdp.bookPackage(FROMDATE, TODATE, COMMENT);
		
		String actualMsg1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		try {
			Assert.assertTrue(actualMsg1.contains(expectedMsg1), "Booking is not successfully created");
			UtilityClassObject.getTest().log(Status.PASS, "Booking is successfully created");
		} catch(AssertionError e) {
			UtilityClassObject.getTest().log(Status.FAIL, e.getMessage());
		}
		
		uhp.getLogoutLnk().click();
	
	}

}
