package com.assignment.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.assignment.constants.FrameworkConstants;
import com.assignment.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Performs initialization and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.listeners.ListenersClass
 * @see com.assignment.annotations.FrameworkAnnotations
 */

public final class ExtentReport {

	/**
	 * Private constructor to avoid external instantiation
	 */

	private ExtentReport() {
	}

	private static ExtentReports extent;

	/**
	 * Sets the initial configuration for the Extent Reports and decides the report generation path.
	 */
	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Kodo Assignment Test Report");
			spark.config().setReportName("Test Results");
		}
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 */
	
	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * 
	 * @param testcasename
	 * Test Name that needs to be reflected in the report
	 */
	
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}

	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives a clear idea of Authors v/s Percentage success metrics
	 * 
	 * @param authors
	 * Authors who created a particular test case
	 */
	
	public static void addAuthors(String[] authors) {
		for(String temp: authors)
			ExtentManager.getExtentTest().assignAuthor(temp);
	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives a clear idea of Group v/s Percentage success metrics.
	 * 
	 * @param categories category a particular test case belongs to.
	 */
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp: categories)
			ExtentManager.getExtentTest().assignCategory(temp.toString());
	}
}
