package com.assignment.reports;

/**
 * Used for logging the events in the extent report.
 * <p>
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see FrameworkLogManager
 */

public class ConsoleLoggerImpl implements Loggable {

	/**
	 * Logs event in the console with the required message
	 */
	
	@Override
	public void log(String status, String message) {
		System.out.println(status + "---->" + message);
	}

}
