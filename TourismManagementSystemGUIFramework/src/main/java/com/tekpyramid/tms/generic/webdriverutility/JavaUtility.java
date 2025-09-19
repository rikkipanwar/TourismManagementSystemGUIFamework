package com.tekpyramid.tms.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}

	public String captureTimeStamp() {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		return time;
	}

	public String getSystemDateddMMyyy() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateObj);
		return date;
	}

	public String getRequiredDate(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		sdf.format(dateObj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}

}