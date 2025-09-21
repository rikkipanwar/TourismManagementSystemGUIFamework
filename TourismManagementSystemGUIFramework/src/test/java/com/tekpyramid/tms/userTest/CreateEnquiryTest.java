package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.objectrepositoryutility.EnquiryPage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;

public class CreateEnquiryTest extends BaseClass {
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void createEnquiryTest() throws EncryptedDocumentException, IOException {
		String expectedMsg = "Enquiry  Successfully";
		
		String FUllNAME = eLib.getDataFromExcel("enquiry", 1, 0);
		String EMAILID = eLib.getDataFromExcel("enquiry", 1, 1) + jLib.getRandomNumber();
		String MOBILENO= eLib.getDataFromExcel("enquiry", 1, 2);
		String SUBJECT = eLib.getDataFromExcel("enquiry", 1, 3);
		String DESCRIPTION = eLib.getDataFromExcel("enquiry", 1, 4);
		
		
		HomePage hp = new HomePage(driver);
		hp.getEnquiryLink().click();
		
		EnquiryPage ep = new EnquiryPage(driver);
		ep.createEnquiry(FUllNAME, EMAILID, MOBILENO, SUBJECT, DESCRIPTION);
		
		String actualMsg = driver.findElement(By.xpath("//div[text()=':Enquiry  Successfully submited ']")).getText();
		
		try {
	        Assert.assertTrue(actualMsg.contains(expectedMsg), "Enquiry is not successfully created");
	        UtilityClassObject.getTest().log(Status.PASS, "Enquiry is successfully created");
	    } catch (AssertionError e) {
	        UtilityClassObject.getTest().log(Status.FAIL, e.getMessage());
	        throw e;
	    }
		
	}

}
