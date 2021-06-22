package com.assignment.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.assignment.driver.DriverManager;

/**
 * Utility to take base64 screenshot.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.reports.ExtentLoggerImpl
 */

public final class ScreenshotUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ScreenshotUtilities() {
	}

	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and returns to the caller.
	 * There is no temporary screenshot image generated here. If the user needs separate screenshot image, they can construct
	 * a new method.
	 * 
	 * @return in the form of Base64 String which can be appended directly to report
	 */
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
