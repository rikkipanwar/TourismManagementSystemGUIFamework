package com.tekpyramid.tms.adminTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.objectrepositoryutility.AdminDashboardPage;
import com.tekpyramid.tms.objectrepositoryutility.AdminLoginPage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;

public class AdminLoginTest  extends BaseClass{
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void adminLoginTest() throws IOException, InterruptedException {
		String actHead = "Administrator";
		String USERNAME = fLib.getDataFromPropertyFile("admin_username");
		String PASSWORD = fLib.getDataFromPropertyFile("admin_password");
		HomePage hp = new HomePage(driver);
		hp.getAdminLoginLink().click();;
		
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginAdmin(USERNAME, PASSWORD);
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		String header = adp.getHeaderAdmin().getText();
		if(header.contains(actHead)) {
			System.out.println("Admistrator dashborad is displayed");
		}else {
			System.out.println("Admistrator dashborad is not displayed");
			
		}
		adp.logoutAdmin();
		alp.getBackToHomeLnk().click();
	}

}
