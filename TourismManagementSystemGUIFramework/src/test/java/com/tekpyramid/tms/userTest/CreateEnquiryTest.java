package com.tekpyramid.tms.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.objectrepositoryutility.EnquiryPage;
import com.tekpyramid.tms.objectrepositoryutility.HomePage;

public class CreateEnquiryTest extends BaseClass {
	
	@Test(groups = "smoke" , retryAnalyzer = com.tekpyramid.tms.generic.listenerutility.RetryListenerImp.class)
	public void createEnquiryTest() throws EncryptedDocumentException, IOException {
		
		String FUllNAME = eLib.getDataFromExcel("enquiry", 1, 0);
		String EMAILID = eLib.getDataFromExcel("enquiry", 1, 1) + jLib.getRandomNumber();
		String MOBILENO= eLib.getDataFromExcel("enquiry", 1, 2);
		String SUBJECT = eLib.getDataFromExcel("enquiry", 1, 3);
		String DESCRIPTION = eLib.getDataFromExcel("enquiry", 1, 4);
		
		
		HomePage hp = new HomePage(driver);
		hp.getEnquiryLink().click();
		
		EnquiryPage ep = new EnquiryPage(driver);
		ep.createEnquiry(FUllNAME, EMAILID, MOBILENO, SUBJECT, DESCRIPTION);
		
		String headerVerify = driver.findElement(By.xpath("//div[text()=':Enquiry  Successfully submited ']")).getText();
		if(headerVerify.contains("Enquiry  Successfully")) {
			System.out.println("Enquiry has been successfully created");
		} else {
			System.out.println("Enquiry has not been successfully created");
		}
	}

}
