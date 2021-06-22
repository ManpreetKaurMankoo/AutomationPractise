package com.assignment.utilities;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.assignment.constants.FrameworkConstants;
import com.assignment.enums.ConfigProperties;
import com.assignment.exceptions.PropertyFileReadException;

/**
 * Reads the property file and stores it in a HashMap for faster processing.
 * Users can prefer to use JSON instead of property file based on their requirement.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class TestConfigReader {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private TestConfigReader() {

	}

	private static Properties prop;

	/**
	 * Eager initialization to load the class file into the memory to save execution time at the time of actual request
	 */
	
	static {
		try(FileInputStream fileInput = new FileInputStream(FrameworkConstants.getConfigFilePropertyPath())) {
			prop = new Properties();
			prop.load(fileInput);
		}

		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Receives the {@link com.assignment.enums.ConfigProperties},converts to lower case , returns the corresponding value
	 * for the key from the HashMap.
	 * 
	 * @param propertyName To be fetched from property file
	 * 
	 * @return corresponding value for the requested key if found else {@link PropertyFileReadException}
	 */
	
	public static String readProperty(ConfigProperties propertyName) {

		if(Objects.isNull(propertyName) || Objects.isNull(prop.getProperty(propertyName.name().toLowerCase())))
			throw new PropertyFileReadException("Property name " + propertyName + " is not found. Please check TestConfig.properties.");
		return prop.getProperty(propertyName.name().toLowerCase()).trim();
	}
}
