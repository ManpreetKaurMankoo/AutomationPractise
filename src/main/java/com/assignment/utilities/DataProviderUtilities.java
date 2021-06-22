package com.assignment.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.assignment.constants.FrameworkConstants;

/**
 * Reads the data through DataProvider for all the test cases in the framework.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class DataProviderUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private DataProviderUtilities() {
	}

	private static List<Map<String, String>> list = new ArrayList<>();

	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @param m
	 * {@link java.lang.reflect.Method} holds the information about the test cases at runtime
	 * 
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 * 
	 * @throws IOException
	 */
	
	@DataProvider(parallel=true)
	public static Object[] getData(Method m) throws IOException {

		String testname = m.getName();

		if(list.isEmpty()) {
			list = ExcelUtilities.getExcelFile(FrameworkConstants.getSearchDataFilePropertyPath(),
					FrameworkConstants.getDataIterationSheet());
		}
		List<Map<String, String>> iterationList = new ArrayList<>();

		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
					list.get(i).get("execute").equalsIgnoreCase("yes")){
				iterationList.add(list.get(i));
			}
		}
		return iterationList.toArray();
	}
}
