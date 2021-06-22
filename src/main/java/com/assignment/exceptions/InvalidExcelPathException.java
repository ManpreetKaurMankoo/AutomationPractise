package com.assignment.exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.constants.FrameworkConstants
 */

@SuppressWarnings("serial")
public class InvalidExcelPathException extends InvalidFilesPathException{

	/**
	 * Pass the message that needs to be appended to the stack trace.
	 * 
	 * @param message
	 * Details about the exception or custom message
	 */
	
	public InvalidExcelPathException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * Details about the exception or custom message
	 * 
	 * @param cause
	 * Pass the enriched stack trace or customized stack trace
	 */
	
	public InvalidExcelPathException(String message, Throwable cause) {
		super(message, cause);
	}
}
