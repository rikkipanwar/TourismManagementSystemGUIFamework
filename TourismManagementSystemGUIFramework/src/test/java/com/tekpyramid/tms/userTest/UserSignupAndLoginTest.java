package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tekpyramid.tms.basetest.BaseClass;
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
			System.out.println("New user is created");
		}else {
			System.out.println("New User is not created");
		}
		

		HomePage hp1 = new HomePage(driver);
		hp1.getSignInLink().click();
		
		SignInPage sip1 = new SignInPage(driver);
		sip1.loginAsUser(EMAIL, PASSWORD);
		
		String header = driver.findElement(By.xpath("//li[@class='sig']")).getText();
		if(header.contains(EMAIL)) {
			System.out.println(" User is login");
		}else {
			System.out.println("User is not login");
			
		}
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getLogoutLnk().click();
	}

}
