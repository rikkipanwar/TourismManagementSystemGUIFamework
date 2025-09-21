package com.tekpyramid.tms.adminTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.AdminDashboardPage;
import com.tekpyramid.tms.objectrepositoryutility.AdminLoginPage;
import com.tekpyramid.tms.objectrepositoryutility.CreatePackagePage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;

public class CreateTourPackageTest extends BaseClass{
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void createTourPackageTest() throws IOException, InterruptedException {
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
	}

}
