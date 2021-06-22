package com.assignment.factories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.constants.FrameworkConstants;
import com.assignment.driver.DriverManager;
import com.assignment.enums.WaitStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class ExplicitWaitFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ExplicitWaitFactory() {
	}

	/**
	 * @param WaitStrategy strategy to be applied to find a WebElement {@link com.assignment.enums.WaitStrategy}
	 * @param by By locator of the WebElement
	 * @return WebElement locates and returns the WebElement
	 */
	
	public static WebElement executeExplicitWaitForElement(By by, WaitStrategy waitStrategy) {

		WebElement element = null;

		if(waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

	public static List<WebElement> executeExplicitWaitForElements(By by, WaitStrategy waitStrategy) {

		List<WebElement> elements = null;

		if(waitStrategy == WaitStrategy.PRESENCE) {
			elements = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}
		else if(waitStrategy == WaitStrategy.VISIBLE) {
			elements = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		}
		else if(waitStrategy == WaitStrategy.NONE) {
			elements = DriverManager.getDriver().findElements(by);
		}
		return elements;
	}
}
