package com.assignment.driver;

import java.util.Objects;

import com.assignment.enums.ConfigProperties;
import com.assignment.factories.DriverFactory;
import com.assignment.utilities.TestConfigReader;

/**
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * <p> It is also responsible for setting the driver variable to DriverManager
 * which handles the thread safety for the WebDriver instance.<p>
 * 
 * @author Manpreet Kaur M
 * 13-Jun-2021
 */

public final class Driver {																

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private Driver() {																																		
	}
	
	/**
	 * Gets the browser value and initialize the browser based on that
	 * 
	 * @param browser
	 * Value will be passed from {@link com.assignment.tests.BaseTest}. Its value can be chrome or firefox.
	 */

	public static void intializeDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {								

			DriverManager.setDriver(DriverFactory.getDriver(browser));
			DriverManager.getDriver().get(TestConfigReader.readProperty(ConfigProperties.URL));
		}
	}

	/**
	 * 
	 * Terminates the browser instance.
	 * Sets the ThreadLocal to default value, i.e null.
	 */
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
