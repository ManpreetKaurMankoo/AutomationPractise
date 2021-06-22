package com.assignment.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.assignment.enums.CategoryType;

/**
 * 
 * <p> FrameworkAnnotations is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotations {
	
	/**
	 * Stores the authors who created the tests in String[]
	 * It is mandatory to enter at least one value
	 */

	public String[] author();
	
	/**
	 * Stores the category in the form of Enum Array. Includes the possible values in {@link com.assignment.enums.CategoryType}
	 */
	
	public CategoryType[] category();

}
