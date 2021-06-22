package com.assignment.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

/**
 * This is a Thread Local class to help create variables that could be read and written by the same thread.
 * helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see Driver
 */

public final class DriverManager {												

	/**
	 * Private constructor to avoid external instantiation
	 */

	private DriverManager() {												
	}

	private static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * 
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */

	public static WebDriver getDriver() {
		return threadSafeDriver.get();
	}

	/**
	 * Sets the WebDriver instance to ThreadLocal variable
	 * 
	 * @param driverRef {@link org.openqa.selenium.WebDriver} instance that needs to be saved from Thread safety issues.<p>
	 */

	static void setDriver(WebDriver driverRef) {
		if(Objects.nonNull(driverRef))
			threadSafeDriver.set(driverRef);
	}

	/**
	 * Calling remove method on ThreadLocal variable ensures to set the default value to ThreadLocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 */

	static void unload() {
		threadSafeDriver.remove();
	}
}
