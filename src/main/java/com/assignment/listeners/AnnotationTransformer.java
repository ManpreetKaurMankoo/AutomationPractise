package com.assignment.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.assignment.utilities.DataProviderUtilities;

/**
 * /**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 * <pre>Remember to add the Listeners details in the testng.xml file</pre>
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.utilities.DataProviderUtilities
 */

public class AnnotationTransformer implements IAnnotationTransformer {

	/**
	 * Sets up and applies the DataProvider and DataProvider class to all the test methods
	 * at run time. 
	 */
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtilities.class);
	}

}
