package com.assignment.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class sets up the browser value
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class DriverFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) {

		WebDriver driver = null;

		/**
		 * Setups the chromedriver using WebDriverManager
		 */
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();								
			driver = new ChromeDriver();
		}

		/**
		 * Setups the firefoxdriver using WebDriverManager
		 */
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();							
			driver = new FirefoxDriver();
		}
		return driver;	
	}

}
