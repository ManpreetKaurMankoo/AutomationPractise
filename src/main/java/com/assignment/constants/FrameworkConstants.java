package com.assignment.constants;

import com.assignment.enums.ConfigProperties;
import com.assignment.utilities.TestConfigReader;

/**
 * Framework Constants holds all the constant values used within the framework.
 * This class is used to fetch the constants through getter methods
 * If some value needs to be changed or modified often, then it should be stored in the property files.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class FrameworkConstants {												

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private FrameworkConstants() {
	}																				

	private static final String PATHOFRESOURCES = System.getProperty("user.dir") + "\\src\\test\\resources";
	private static final String CONFIGFILE_PROPERTYPATH = PATHOFRESOURCES + "\\config\\TestConfig.properties";
	private static final String TESTINFOEXCELPATH = PATHOFRESOURCES + "\\data\\TestInformation.xlsx";
	private static final String SEARCHDATAFILE_PROPERTYPATH = PATHOFRESOURCES + "\\data\\SearchData.xlsx";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"\\extentreport-test-output";
	private static String extentReportFilePath = "";
	private static final String TESTINFORMATIONSHEET = "TestInformation";
	private static final String DATAITERATIONSHEET = "SearchData";

	private static final int EXPLICITWAIT = 20;
	private static final int PAUSE = 15;
	private static final int UNINTERRUPTIBLESWAIT = 5;

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePropertyPath() {
		return CONFIGFILE_PROPERTYPATH;
	}

	public static String getSearchDataFilePropertyPath() {
		return SEARCHDATAFILE_PROPERTYPATH;
	}

	/**
	 * 
	 * @return Extent Report path where the index.html file will be generated.
	 */
	
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	/**
	 * 
	 * @return If overridereports value in TestConfig.propertis file is No,
	 * then time stamp will be appended
	 */
	
	private static String createReportPath() {
		if(TestConfigReader.readProperty(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	public static String getTestInfoExcelPath() {
		return TESTINFOEXCELPATH;
	}

	public static String getTestInformationSheet() {
		return TESTINFORMATIONSHEET;
	}

	public static String getDataIterationSheet() {
		return DATAITERATIONSHEET;
	}

	public static int getExplicitPause() {
		return PAUSE;
	}

	public static int getUninterruptiblesWait() {
		return UNINTERRUPTIBLESWAIT;
	}
	
}
