package com.assignment.exceptions;

/**
 * Runtime Exception occurs when the path given for property file is incorrect.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.constants.FrameworkConstants
 */

@SuppressWarnings("serial")
public class PropertyFileReadException extends FrameworkException{

	/**
	 * Pass the message that needs to be appended to the stack trace.
	 * 
	 * @param message
	 * Details about the exception or custom message
	 */
	
	public PropertyFileReadException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * Details about the exception or custom message
	 * 
	 * @param cause
	 * Pass the enriched stack trace or customized stack trace
	 */
	
	public PropertyFileReadException(String message, Throwable cause) {
		super(message, cause);
	}
}
