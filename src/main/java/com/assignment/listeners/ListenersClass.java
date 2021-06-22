package com.assignment.listeners;

import java.util.Arrays;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.assignment.annotations.FrameworkAnnotations;
import com.assignment.reports.ExtentLoggerImpl;
import com.assignment.reports.ExtentReport;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * and to help in extent report generation.
 * 
 * <pre>Please remember to add the Listeners details in the testng.xml file</pre>
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public class ListenersClass implements ITestListener, ISuiteListener{

	/**
	 * Initializes the reports with the file name
	 * @see com.assignment.reports.ExtentReport
	 */
	
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();	
	}

	/**
	 * Terminates the reports
	 * @see com.assignment.reports.ExtentReport
	 */
	
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();	
	}
	
	/**
	 * Starts a test node for each TestNG test
	 * @see com.assignment.reports.ExtentReport
	 * @see com.assignment.annotations.FrameworkAnnotations
	 */

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());	
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
	}

	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.assignment.reports.ExtentLoggerImpl
	 */
	
	@Override
	public void onTestSuccess(ITestResult result) {
		new ExtentLoggerImpl().log("pass", result.getMethod().getMethodName() + " is passed");
	}

	/**
	 * Marks the test as fail, appends base64 screenshot and logs it in the report
	 * @see com.assignment.reports.ExtentLoggerImpl
	 * @see com.assignment.utilities.ScreenshotUtilities
	 */
	
	@Override
	public void onTestFailure(ITestResult result) {
		new ExtentLoggerImpl().log("fail", result.getMethod().getMethodName() + " is failed");
		ExtentLoggerImpl.fail(result.getThrowable().toString());
		ExtentLoggerImpl.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}
	
	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.assignment.reports.ExtentLoggerImpl
	 */

	@Override
	public void onTestSkipped(ITestResult result) {	
		new ExtentLoggerImpl().log("skip", result.getMethod().getMethodName() + " is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * No implementation required as of now
		 */
	}



}
