package com.assignment.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.assignment.constants.FrameworkConstants;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Utility class to perform actions on a web page
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class ActionsUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ActionsUtilities() {
	}

	static Actions actions;

	/**
	 * Takes the WebElement and hovers over and clicks on it
	 * 
	 * @param driver
	 * {@link org.openqa.selenium.WebDriver} instance.
	 * 
	 * @param element WebElement to be hovered over and clicked on
	 */
	
	public static void hoverAndClickWithActionsClass(WebDriver driver, WebElement element){
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		Uninterruptibles.sleepUninterruptibly(FrameworkConstants.getUninterruptiblesWait(), TimeUnit.SECONDS);
	}

	/**
	 * Takes the WebElement and hovers over it
	 * 
	 * @param driver
	 * {@link org.openqa.selenium.WebDriver} instance.
	 * 
	 * @param element WebElement to be hovered over
	 */
	
	public static void hoverWithActionsClass(WebDriver driver, WebElement element){
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		Uninterruptibles.sleepUninterruptibly(FrameworkConstants.getUninterruptiblesWait(), TimeUnit.SECONDS);
	}
}
