package com.tekpyramid.tms.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
		spark = new ExtentSparkReporter("./AdvanceRepot/report.html");
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
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===STARTED===");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getMethodName() + "===SUCCESS===");
	}
	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromPath(srcFile, testName+"_" + time);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===FAILED===");
	}
	

}
