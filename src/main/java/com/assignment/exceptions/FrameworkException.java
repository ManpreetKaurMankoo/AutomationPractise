package com.assignment.exceptions;

/**
 * This is the BaseException for the framework.
 * It extends RuntimeException and can be thrown anywhere to terminate a program.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {

	/**
	 * Pass the message that needs to be appended to the stack trace.
	 * 
	 * @param message
	 * Details about the exception or custom message
	 */
	
	public FrameworkException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * Details about the exception or custom message
	 * 
	 * @param cause
	 * Pass the enriched stack trace or customized stack trace
	 */
	
	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}
}
