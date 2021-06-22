package com.assignment.reports;

/**
 * Customised interface with an abstract method to be implemented by ExtentLoggerImpl and ConsoleLoggerImpl for logging events
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */
public interface Loggable {
	
	abstract void log(String status, String message);

}
