package com.assignment.utilities;

/**
 * Constructs a dynamic XPath at run time.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */
public final class DynamicXpathUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private DynamicXpathUtilities() {
	}

	protected static String[] word = new String[10];

	/**
	 * Receives a wild card string, replaces the wild card with the value and returns to the caller
	 * 
	 * @param xpath
	 * XPath with wild card string
	 * 
	 * @param value
	 * value to be replaced in place of wild card
	 * 
	 * @return dynamic XPath string
	 */
	
	public static String getXpath(String xpath, String value) {
		return xpath.replace("%s%", value);
	}

	/**
	 * Receives a wild card string, replaces the wild card with the values and returns to the caller
	 * 
	 * @param xpath
	 * XPath with wild card string
	 * 
	 * @param value1
	 * value to be replaced in place of wild card
	 * 
	 * @param value2
	 * value to be replaced in place of wild card
	 * 
	 * @return dynamic XPath string
	 */
	
	public static String getXpath(String xpath, String value1, String value2) {
		return xpath.replace("%s1%", value1).replace("%s2%", value2);
	}

	/**
	 * Receives a wild card string, appends the wild card with some values and returns to the caller
	 * 
	 * @param xpathToBeAppended
	 * XPath with wild card string
	 * 
	 * @param keyword
	 * Keyword on the basis of which some need to be appended
	 * 
	 * @return dynamic XPath string
	 */
	
	public static String getAppendedXpath(String xpathToBeAppended, String keyword) {

		StringBuilder builder = new StringBuilder(xpathToBeAppended);
		String stringToBeAppended = "contains(text(),'%s%')";
		String[] keywordArray = keyword.split(" ", 0);
		int keywordSize = keywordArray.length;

		String appendedXpath = null;
		for(int i=0; i<keywordArray.length; i++) {
			word[i] = keywordArray[i];

			if(i==0) {
				appendedXpath = builder.append(stringToBeAppended.replace("%s%", word[i])).toString();
			}
			else if(i==keywordSize-1) {
				appendedXpath = builder.append(" or ").append(stringToBeAppended.replace("%s%", word[i])).append("]").toString();
			}
			else {
				appendedXpath = builder.append(" or ").append(stringToBeAppended.replace("%s%", word[i])).toString();
			}

			appendedXpath = appendedXpath.replace("%s1%", word[i]);
		}
		return appendedXpath;
	}
}

