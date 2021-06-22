package com.assignment.exceptions;

/**
 * Runtime Exception occurs when the excel file cannot be read.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.utilities.TestConfigReader
 */

@SuppressWarnings("serial")
public class ExcelFileReadException extends FrameworkException {
	
	/**
	 * Pass the message that needs to be appended to the stack trace.
	 * 
	 * @param message
	 * Details about the exception or custom message
	 */
	public ExcelFileReadException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * Details about the exception or custom message
	 * 
	 * @param cause
	 * Pass the enriched stack trace or customized stack trace
	 */
	
	public ExcelFileReadException(String message, Throwable cause) {
		super(message, cause);
	}
}
