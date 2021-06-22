package com.assignment.exceptions;

/**
 * Runtime Exception occurs when the path given for any of the files is incorrect.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.exceptions.InvalidExcelPathException
 * @see com.assignment.exceptions.InvalidPropertyFileReadException
 */

@SuppressWarnings("serial")
public class InvalidFilesPathException extends FrameworkException {

	/**
	 * Pass the message that needs to be appended to the stack trace.
	 * 
	 * @param message
	 * Details about the exception or custom message
	 */
	
	public InvalidFilesPathException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * Details about the exception or custom message
	 * 
	 * @param cause
	 * Pass the enriched stack trace or customized stack trace
	 */
	
	public InvalidFilesPathException(String message, Throwable cause) {
		super(message, cause);
	}
}
