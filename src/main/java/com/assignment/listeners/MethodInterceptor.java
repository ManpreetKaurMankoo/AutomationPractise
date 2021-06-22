package com.assignment.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.assignment.constants.FrameworkConstants;
import com.assignment.utilities.ExcelUtilities;

/**
 * Implements {@link org.testng.IMethodInterceptor} to leverage the abstract methods
 * Helps to read the data from excel and decides on which tests needs to run.
 * 
 * <pre>Remember to add the listener details in the testng.xml file</pre>
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.utilities.ExcelUtilities
 */

public class MethodInterceptor implements IMethodInterceptor {

	/**
	 * Intercepts the existing test methods and changes the annotation value at the run time.
	 * Values are fetched from the excel sheet.
	 * User has to mention yes/no in the TestInformation sheet.
	 * Suppose if there are 3 tests named a, b, c and only a and c need to be run, it reads the excel and understands that and
	 * returns the same after performing the comparisons.
	 */
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> list = null;
		try {
			list = ExcelUtilities.getExcelFile(FrameworkConstants.getTestInfoExcelPath(), FrameworkConstants.getTestInformationSheet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<IMethodInstance> result = new ArrayList<>();

		for(int i=0; i<methods.size();i++) {
			for(int j=0; j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) && list.get(j).get("execute").equalsIgnoreCase("yes")) {
					methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}

}
