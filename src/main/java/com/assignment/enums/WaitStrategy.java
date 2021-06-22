package com.assignment.enums;

/**
 * Enums to restrict the users and choose an appropriate waiting strategy before operating on an element.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.factories.ExplicitWaitFactory
 * @see com.assignment.pages.BasePage
 */

public enum WaitStrategy {
	
	VISIBLE,
	PRESENCE,
	CLICKABLE,
	NONE

}
