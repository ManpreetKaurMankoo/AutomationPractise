package com.assigment.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.assignment.driver.Driver;
import com.assignment.driver.DriverManager;

/**
 * Acts as a parent class for all the test classes in this framework.
 * All the test classes need to extend this class. This class is responsible for invoking and terminating
 * browser under test.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public class BaseTest {

	protected BaseTest() {													
	}

	/**
	 * Invokes a new browser instance and loads the respective URL.
	 * 
	 * @param data
	 * Have all the data fed to the corresponding test method from data provider. In our case,it is
	 * a HashMap containing all the values from the excel sheet.
	 */
	
	@BeforeMethod
	protected static void setUp(Object[] data) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.intializeDriver(map.get("browser"));
		DriverManager.getDriver().manage().window().maximize();				 
	}

	/**
	 * Terminates the browser instance
	 */
	
	@AfterMethod
	protected static void tearDown() {
		Driver.quitDriver();
	}

}
