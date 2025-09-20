package com.tekpyramid.tms.adminTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.AdminDashboardPage;
import com.tekpyramid.tms.objectrepositoryutility.AdminLoginPage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.UpdatePackagesPage;

public class ManageTourPackageTest extends BaseClass{
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void createTourPackageTest() throws IOException, InterruptedException {
		String USERNAME = fLib.getDataFromPropertyFile("admin_username");
		String PASSWORD = fLib.getDataFromPropertyFile("admin_password");
		
		String PACKAGENAME = eLib.getDataFromExcel("packages", 1, 0);
		String PACKAGETYPE = eLib.getDataFromExcel("packages", 1, 1) + jLib.getRandomNumber();
		String PACKAGEPRICE = eLib.getDataFromExcel("packages", 1, 3) + jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getAdminLoginLink().click();;
		
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginAdmin(USERNAME, PASSWORD);
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getTourPackagesLnk().click();
		adp.getManageLnk().click();
		
		WebElement viewDetails = driver.findElement(By.xpath("//span[text()='"+PACKAGENAME+"']/../../descendant::button[text()='View Details']"));
		wLib.obscuredElementClick(driver, viewDetails);
		
		UpdatePackagesPage upp = new UpdatePackagesPage(driver);
		upp.updatePackage(PACKAGETYPE, PACKAGEPRICE);
		
		String header = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(header.contains("Package Updated")) {
			UtilityClassObject.getTest().log(Status.PASS, "Package is updated successfully");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL, "Package is not updated successfully");
		}
		
		adp.logoutAdmin();
		alp.getBackToHomeLnk().click();
	}

}
