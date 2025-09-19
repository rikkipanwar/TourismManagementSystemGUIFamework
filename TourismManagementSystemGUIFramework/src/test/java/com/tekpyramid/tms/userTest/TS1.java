package com.tekpyramid.tms.userTest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(getSystemDateddmmyyy());
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://49.249.28.218:8081/AppServer/Online_Tourism_Management_System/package-details.php?pkgid=6");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		
//		WebElement ele = driver.findElement(By.xpath("//input[@id='datepicker']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", ele);
//		Actions action = new Actions(driver);
//		action.sendKeys(ele, "25-09-2025").sendKeys(Keys.ENTER).perform();
		
	}
	
	public static String getSystemDateddmmyyy() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");
		String date = sdf.format(dateObj);
		return date;
	}

}
