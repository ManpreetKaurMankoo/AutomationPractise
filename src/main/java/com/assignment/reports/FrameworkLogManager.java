package com.assignment.reports;

import com.assignment.enums.ConfigProperties;
import com.assignment.utilities.TestConfigReader;

/**
 * Log manager to manage all the logs of the framework
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class FrameworkLogManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private FrameworkLogManager() {
	}

	/**
	 * Implements the getLogType message of the Loggable customised interface and logs the pass event
	 * 
	 * @param message
	 * Message to be shown in the extent reports and console for the passed events
	 */
	
	public static void getLogtype(String message) {
		if(TestConfigReader.readProperty(ConfigProperties.LOGINEXTENT).equalsIgnoreCase("yes")) {
			new ExtentLoggerImpl().log("pass", message);
		}
		if(TestConfigReader.readProperty(ConfigProperties.LOGINCONSOLE).equalsIgnoreCase("yes")) {
			new ConsoleLoggerImpl().log("pass", message);
		}
	}
}
