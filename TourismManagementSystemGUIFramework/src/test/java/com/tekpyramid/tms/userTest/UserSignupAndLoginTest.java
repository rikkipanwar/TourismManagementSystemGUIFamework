package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.SignInPage;
import com.tekpyramid.tms.objectrepositoryutility.SignUpPage;
import com.tekpyramid.tms.objectrepositoryutility.UserHomePage;

public class UserSignupAndLoginTest extends BaseClass {
	
	@Test(groups = "integration" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void userSignupAndLoginTest() throws EncryptedDocumentException, IOException {
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
		if(confirmMsg.contains("successful")) {
			UtilityClassObject.getTest().log(Status.PASS, "New user is successfully created");
		}else {
			UtilityClassObject.getTest().log(Status.FAIL, "New user is not successfully created");
		}
		

		HomePage hp1 = new HomePage(driver);
		hp1.getSignInLink().click();
		
		SignInPage sip1 = new SignInPage(driver);
		sip1.loginAsUser(EMAIL, PASSWORD);
		
		String header = driver.findElement(By.xpath("//li[@class='sig']")).getText();
		if(header.contains(EMAIL)) {
			UtilityClassObject.getTest().log(Status.PASS, "New user is logged In");
		}else {
			UtilityClassObject.getTest().log(Status.FAIL, "New user is not logged In");
			
		}
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getLogoutLnk().click();
	}

}
