package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.assignment.driver.DriverManager;
import com.assignment.enums.WaitStrategy;
import com.assignment.utilities.ActionsUtilities;
import com.assignment.utilities.DynamicXpathUtilities;

/**
 * Home web page class for performing Selenium operations on Home page WebElements
 * This class extends the BasePage class.
 * 
 * @author Manpreet Kaur M
 * 13-Jun-2021
 */

public final class HomePage extends BasePage {													
	
	private String productsPageLink = "(//a[@title='%s1%'])[%s2%]";
	private String searchTextField = "search_query_top";
	private String searchButton = "submit_search";
	private String autoSuggestionField = "//*[@class='ac_results']";
	private String autoSuggestedValues = "//*[@class='ac_results']/ul/li";
	
	public DressPage clickProductTypePage(String product, String index) {
		String newXpathForProductsLinkPage = DynamicXpathUtilities.getXpath(productsPageLink, product, index);
		ActionsUtilities.hoverAndClickWithActionsClass(DriverManager.getDriver(),
				hoverAndClick(By.xpath(newXpathForProductsLinkPage), WaitStrategy.CLICKABLE, product + " page link"));
		return new DressPage();
	}
	
	public HomePage clearSearchField() {
		clearText(By.id(searchTextField), WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}
	
	public HomePage enterSearchKeyword(String searchKeyword) {
		sendKeys(By.id(searchTextField), searchKeyword, WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}
	
	public SearchPage clickSearchBtn() {
		click(By.name(searchButton), WaitStrategy.CLICKABLE, "Search button");
		return new SearchPage();
	}

	public boolean checkAutoSuggestionIsDisplayed() {
		return isDisplayed(By.xpath(autoSuggestionField), WaitStrategy.VISIBLE, "Auto suggestion ");
	}
	
	public List<String> getAllTheSuggestedProducts() {
		return getTextOfAllElements(By.xpath(autoSuggestedValues), WaitStrategy.VISIBLE, "Related suggested products ");
	}
}
