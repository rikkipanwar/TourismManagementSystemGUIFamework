package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;
import com.tekpyramid.tms.objectrepositoryutility.SignInPage;
import com.tekpyramid.tms.objectrepositoryutility.UserHomePage;

public class UserLoginTest  extends BaseClass{
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void userLoginTest() throws IOException, InterruptedException {
		String USERNAME = eLib.getDataFromExcel("signin", 1, 0);
		String PASSWORD = eLib.getDataFromExcel("signin", 1, 1);
		HomePage hp = new HomePage(driver);
		hp.getSignInLink().click();
		
		SignInPage sip = new SignInPage(driver);
		sip.loginAsUser(USERNAME, PASSWORD);
		
		String header = driver.findElement(By.xpath("//li[@class='sig']")).getText();
		if(header.contains(USERNAME)) {
			System.out.println(" User is login");
		}else {
			System.out.println("User is not login");
			
		}
		
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getLogoutLnk().click();
	}

}
