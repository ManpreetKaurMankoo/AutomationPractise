package com.assignment.enums;

/**
 * Enums to restrict the values used in Property files. Without using enums, there can be NullPointerExceptions
 * because of typos.
 * <p>
 * Whenever a new value is added to a property file, corresponding enum should be created here.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.utilities.TestConfigReader
 */

public enum ConfigProperties {
	
	URL,
	BROWSER,
	OVERRIDEREPORTS,
	PASSEDSCREENSHOT,
	FAILEDSCREENSHOT,
	SKIPPEDSCREENSHOT,
	LOGINEXTENT,
	LOGINCONSOLE

}
