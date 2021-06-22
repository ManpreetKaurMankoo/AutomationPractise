package com.assignment.reports;

import com.assignment.enums.ConfigProperties;
import com.assignment.utilities.ScreenshotUtilities;
import com.assignment.utilities.TestConfigReader;
import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see ExtentReport
 * @see ExtentManager
 * @see FrameworkLogManager
 */

public class ExtentLoggerImpl implements Loggable {

	/**
	 * Logs pass, fail, skip events in the extent report based on user input in property file
	 */
	
	@Override
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
			if(TestConfigReader.readProperty(ConfigProperties.PASSEDSCREENSHOT).equalsIgnoreCase("yes")) {
				ExtentManager.getExtentTest()
				.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilities.getBase64Image()).build());
			}
			else {
				pass(message);
			}
		}

		else if(status.equalsIgnoreCase("fail")) {
			if(TestConfigReader.readProperty(ConfigProperties.FAILEDSCREENSHOT).equalsIgnoreCase("yes")) {
				ExtentManager.getExtentTest()
				.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilities.getBase64Image()).build());
			}
			else {
				fail(message);
			}
		}

		else if(status.equalsIgnoreCase("skip")) {
			if(TestConfigReader.readProperty(ConfigProperties.SKIPPEDSCREENSHOT).equalsIgnoreCase("yes")) {
				ExtentManager.getExtentTest()
				.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtilities.getBase64Image()).build());
			}
			else {
				skip(message);
			}
		}
	}

	/**
	 * Logs pass event in the extent report
	 * 
	 * @param message
	 * custom message that needs to be logged
	 */
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);

	}

	/**
	 * Logs fail event in the extent report
	 * 
	 * @param message
	 * message custom message that needs to be logged
	 */
	
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	/**
	 * Logs skip event in the extent report
	 * 
	 * @param message
	 * custom message that needs to be logged
	 */
	
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);

	}
}
