package com.assignment.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.assignment.constants.FrameworkConstants;
import com.assignment.enums.WaitStrategy;
import com.assignment.factories.ExplicitWaitFactory;
import com.assignment.reports.FrameworkLogManager;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Acts as a parent class for all the web pages in this framework.
 * All the web page classes need to extend this class. This class is responsible for locating WebElements
 * by the given WaitStrategy and performing given operations
 * 
 * Base Page common to all the web pages for locating WebElements
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public class BasePage {
	
	/**
	 * Locates the element by the given WaitStrategy, performs the clearText operation on WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 */

	protected void clearText(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		element.clear();
		FrameworkLogManager.getLogtype(elementName + " is cleared");
	}

	/**
	 * Locates the element by the given WaitStrategy, sends the value to the located WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param value
	 * value to be send the text box
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 */
	
	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		element.sendKeys(value);
		FrameworkLogManager.getLogtype(value + " is entered in " + elementName);
	}

	/**
	 * Locates the element by the given WaitStrategy, performs the clicking operation on WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 */
	
	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		element.click();
		FrameworkLogManager.getLogtype(elementName + " is clicked");
	}

	/**
	 * Locates the element by the given WaitStrategy, gets the attribute of the WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @param propertyName
	 * Property name to get the required attribute of the WebElement
	 * @return attribute value of the WebElement
	 */
	
	protected String getAttribute(By by, WaitStrategy waitStrategy, String elementName, String propertyName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		element.click();
		FrameworkLogManager.getLogtype(elementName + " is clicked");
		Uninterruptibles.sleepUninterruptibly(FrameworkConstants.getExplicitPause(), TimeUnit.SECONDS);
		return element.getAttribute(propertyName);
	}

	/**
	 * Locates the element by the given WaitStrategy, performs the hover and click operation on WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return WebElement to be hovered over and clicked on
	 */
	
	protected WebElement hoverAndClick(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " is clicked");
		return element;
	}

	/**
	 * Locates the element by the given WaitStrategy, performs the hover operation on WebElement and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return WebElement to be hovered over
	 */
	
	protected WebElement hover(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " is hovered");
		return element;
	}

	/**
	 * Locates the element by the given WaitStrategy, checks if the WebElement is displayed and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return WebElement to be displayed
	 */
	
	protected boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " is displayed");
		return element.isDisplayed();
	}

	/**
	 * Locates the elements by the given WaitStrategy to get their size and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return size of the list of WebElemenst
	 */
	
	protected int getElements(By by, WaitStrategy waitStrategy, String elementName) {
		List<WebElement> elements = ExplicitWaitFactory.executeExplicitWaitForElements(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " count is obtained");
		return elements.size();
	}

	/**
	 * Locates the element by the given WaitStrategy to get its text and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return the text of the WebElement
	 */
	
	protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.executeExplicitWaitForElement(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " is retrieved");
		return element.getText();
	}

	/**
	 * Locates the elements by the given WaitStrategy to get their text basis product names and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return a list of text of all the products basis product names
	 */
	
	protected List<String> getTextOfAllElements(By by, WaitStrategy waitStrategy, String elementName) {
		List<WebElement> elements = ExplicitWaitFactory.executeExplicitWaitForElements(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " are only retrieved");
		return elements.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	/**
	 * Locates the elements by the given WaitStrategy to get their text basis product prices and
	 * writes the pass even to the extent report.
	 * 
	 * @param by
	 * By Locator of the WebElement
	 * 
	 * @param waitStrategy
	 * waitStrategy Strategy to find WebElement. Known  strategies {@link com.assignment.enums.WaitStrategy}
	 * 
	 * @param elementName
	 * Name of the element that needs to be logged in the report.
	 * 
	 * @return a list of text of all the products basis product prices
	 */
	
	protected List<String> getPricesOfAllElements(By by, WaitStrategy waitStrategy, String elementName) {
		List<WebElement> elements = ExplicitWaitFactory.executeExplicitWaitForElements(by, waitStrategy);
		FrameworkLogManager.getLogtype(elementName + " are retrieved");
		return elements.stream().map(WebElement::getText).filter(price -> price.startsWith("$"))
				.map(price -> price.substring(1)).map(decimal -> decimal.replace(".", "")).collect(Collectors.toList());
	}
	
}
