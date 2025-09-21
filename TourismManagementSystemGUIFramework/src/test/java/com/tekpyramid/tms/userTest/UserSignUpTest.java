package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.SignUpPage;

public class UserSignUpTest extends BaseClass {
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void userSignUpTest() throws EncryptedDocumentException, IOException {
		String expectedMsg = "successful";
		
		String FULLNAME = eLib.getDataFromExcel("signup", 1, 0);
		String MOBNO = eLib.getDataFromExcel("signup", 1, 1);
		String EMAIL = eLib.getDataFromExcel("signup", 1, 2) + jLib.getRandomNumber();
		String PASSWORD = eLib.getDataFromExcel("signup", 1, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getSignUpLink().click();
		
		SignUpPage sip = new SignUpPage(driver);
		sip.createNewUser(FULLNAME, MOBNO, EMAIL, PASSWORD);
		
		WebElement info = driver.findElement(By.xpath("//h4[text()='  Info successfully submited ']"));
		wLib.waitForElementPresent(driver, info);
		String confirmMsg = info.getText();
		
		try {
	        Assert.assertTrue(confirmMsg.contains(expectedMsg), "New user is not successfully created");
	        UtilityClassObject.getTest().log(Status.PASS, "New user is successfully created");
	    } catch (AssertionError e) {
	        UtilityClassObject.getTest().log(Status.FAIL, e.getMessage());
	        throw e;
	    }
		
	}

}
