package com.tekpyramid.tms.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tekpyramid.tms.generic.fileutility.ExcelUtility;
import com.tekpyramid.tms.generic.fileutility.FileUtility;
import com.tekpyramid.tms.generic.webdriverutility.JavaUtility;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;
import com.tekpyramid.tms.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver = null;
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("=====Launch the Browser====");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("====Open URL====");
		driver.get(fLib.getDataFromPropertyFile("url"));
		wLib.waitForPageToLoad(driver);
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("====Close the Browser====");
		driver.quit();
	}
	
	
	

}
