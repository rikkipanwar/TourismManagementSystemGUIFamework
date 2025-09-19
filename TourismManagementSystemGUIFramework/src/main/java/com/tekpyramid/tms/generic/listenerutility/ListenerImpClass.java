package com.tekpyramid.tms.generic.listenerutility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tekpyramid.tms.basetest.BaseClass;
import com.tekpyramid.tms.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ISuiteListener, ITestListener {
	
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		spark = new ExtentSparkReporter("/AdvanceRepot/report.html");
		spark.config().setDocumentTitle("TMS TestSuite Results");
		spark.config().setReportName("TMS Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "FIREFOX");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + " started===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + " success===");
	}
	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			File desFile = new File("./screenshot/"+testName+" " + time+".png");
			FileUtils.copyFile(srcFile, desFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
