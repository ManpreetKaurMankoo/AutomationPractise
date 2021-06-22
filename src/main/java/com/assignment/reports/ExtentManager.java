package com.assignment.reports;

import java.util.Objects;
import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see Driver
 */

public final class ExtentManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> threadSafeExtentTest = new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * 
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	
	static ExtentTest getExtentTest() {
		return threadSafeExtentTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
	
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test)) {
			threadSafeExtentTest.set(test);
		}
	}

	/**
	 * Calling remove method on ThreadLocal variable ensures to set the default value to ThreadLocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 */
	
	static void unload() {
		threadSafeExtentTest.remove();
	}
}
