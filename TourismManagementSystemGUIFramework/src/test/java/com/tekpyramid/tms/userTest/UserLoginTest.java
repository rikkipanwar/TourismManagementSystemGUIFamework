package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.SignInPage;
import com.tekpyramid.tms.objectrepositoryutility.UserHomePage;

public class UserLoginTest  extends BaseClass{
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void userLoginTest() throws EncryptedDocumentException, IOException  {
		String USERNAME = eLib.getDataFromExcel("signin", 1, 0);
		String PASSWORD = eLib.getDataFromExcel("signin", 1, 1);
		HomePage hp = new HomePage(driver);
		hp.getSignInLink().click();
		
		SignInPage sip = new SignInPage(driver);
		sip.loginAsUser(USERNAME, PASSWORD);
		
		String actualMsg = driver.findElement(By.xpath("//li[@class='sig']")).getText();
		
		try {
	        Assert.assertTrue(actualMsg.contains(USERNAME), "User is not logged In");
	        UtilityClassObject.getTest().log(Status.PASS, "User is logged In");
	    } catch (AssertionError e) {
	        UtilityClassObject.getTest().log(Status.FAIL, e.getMessage());
	        throw e;
	    }
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getLogoutLnk().click();
	}

}
