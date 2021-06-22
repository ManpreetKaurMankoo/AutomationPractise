package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.assignment.driver.DriverManager;
import com.assignment.enums.WaitStrategy;
import com.assignment.utilities.ActionsUtilities;
import com.assignment.utilities.DynamicXpathUtilities;

/**
 * Search web page class for performing Selenium operations on Search page WebElements
 * This class extends the BasePage class.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */
public final class SearchPage extends BasePage {

	private String searchTextField = "search_query_top";
	private String searchButton = "submit_search";
	private String searchBreadCrumb = "//*[@class='navigation_page'][text()='Search']";
	private String searchPageOtherField = "//*[@id='%s%']";
	private String sortByOptionSelector ="uniform-selectProductSort";
	private String sortByLowestPriceFirstOption ="//*[@id='uniform-selectProductSort']//option[@value='price:asc']";
	private String sortByOptionDropDown = "//*[@id='uniform-selectProductSort']//option[@value='%s%']";
	private String searchedProductList = "//*[@class='product-container']";
	private String searchedProductsByPrices = "//div[@class='right-block']//span[@class='price product-price']";
	private String searchedProductsByName = "//*[@class='right-block']//a[@class='product-name']";
	private String relatedProductsByName = "//div[@class='right-block']//a[";
	private String productContainerButton = "//*[contains(text(), '%s%')]";
	private String popUpOrPDPage = "//*[@class='%s%']";
	private String productContainerLink = "//*[@class='%s%']";
	private String viewLink = "%s%";

	public SearchPage clearSearchField() {
		clearText(By.id(searchTextField), WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}

	public SearchPage enterSearchKeyword(String searchKeyword) {
		sendKeys(By.id(searchTextField), searchKeyword, WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}

	public SearchPage clickSearchBtn() {
		click(By.name(searchButton), WaitStrategy.CLICKABLE, "Search button");
		return new SearchPage();
	}

	public boolean checkSearchBreadCrumbIsDisplayed() {
		return isDisplayed(By.xpath(searchBreadCrumb), WaitStrategy.VISIBLE, "Search in Bread crumb");
	} 

	public List<String> getProductsRelatedToTheSearchOnly(String keyword) {
		String newXpathForRelatedProductsByName = DynamicXpathUtilities.getAppendedXpath(relatedProductsByName, keyword);
		return getTextOfAllElements(By.xpath(newXpathForRelatedProductsByName), 
				WaitStrategy.VISIBLE, "Products related to " + keyword + " as expected");
	}

	public SearchPage getSearchedProductsCount() {
		getElements(By.xpath(searchedProductList), WaitStrategy.VISIBLE, "Product");
		return this;
	}

	public SearchPage getProductPriceImageCount(String productElement) {
		getElements(By.xpath(searchedProductsByPrices), WaitStrategy.VISIBLE, productElement);
		return this;
	}

	public List<String> getSearchedProductsByName(String keyword) {
		return getTextOfAllElements(By.xpath(searchedProductsByName), WaitStrategy.VISIBLE, "Products related to " + keyword);
	}
	
	public List<String> getSearchedProductsByPrices(String keyword) {
		return getPricesOfAllElements(By.xpath(searchedProductsByPrices), WaitStrategy.VISIBLE, "Products sorted by " + keyword);
	}
	
	public SearchPage clickProductContainerButton(String productElement) {
		String newXpathForProductContainerButton = DynamicXpathUtilities.getXpath(productContainerButton, productElement);
		ActionsUtilities.hoverWithActionsClass(DriverManager.getDriver(),
				hover(By.xpath(searchedProductList), WaitStrategy.CLICKABLE, productElement));
		click(By.xpath(newXpathForProductContainerButton), WaitStrategy.CLICKABLE, productElement);
		return this;
	}
	
	public boolean checkPopUpOrPDPIsDisplayed(String replacingValue) {
		String newXpathForPopUp = DynamicXpathUtilities.getXpath(popUpOrPDPage, replacingValue);
		return isDisplayed(By.xpath(newXpathForPopUp), WaitStrategy.VISIBLE, "Required pop up");
	}
	
	public SearchPage clickProductElementLink(String replacingValue, String productElement) {
		String newXpathForProductElementLink = DynamicXpathUtilities.getXpath(productContainerLink, replacingValue);
		ActionsUtilities.hoverWithActionsClass(DriverManager.getDriver(),
				hover(By.xpath(searchedProductList), WaitStrategy.CLICKABLE, productElement));
		click(By.xpath(newXpathForProductElementLink), WaitStrategy.CLICKABLE, productElement);
		return this;		
	}
	
	public boolean checkSearchPageFieldIsDisplayed(String replacingValue, String searchPageField) {
		String newXpathForFieldsOnSearchPage = DynamicXpathUtilities.getXpath(searchPageOtherField, replacingValue);
		return isDisplayed(By.xpath(newXpathForFieldsOnSearchPage), WaitStrategy.VISIBLE, searchPageField);
	}
	
	public String getViewAttributeValue(String replacingValue, String propertyName) {
		String newXpathForViewLink = DynamicXpathUtilities.getXpath(viewLink, replacingValue);
		return getAttribute(By.id(newXpathForViewLink), WaitStrategy.CLICKABLE, "Selected " + replacingValue + " view", propertyName);		
	}

	public SearchPage clickOnSortByOption() {
		click(By.id(sortByOptionSelector), WaitStrategy.CLICKABLE, "Sort by option");
		return this;
	}
	
	public SearchPage clickOnTheRequiredSortOption(String replacingValue, String sortByOption) {
		String newXpathForSortByOption = DynamicXpathUtilities.getXpath(sortByOptionDropDown, replacingValue);
		click(By.xpath(newXpathForSortByOption), WaitStrategy.CLICKABLE, sortByOption + " Sort option");
		return this;
	}

	public SearchPage clickOnSortByLowestPriceFirstOption() {
		click(By.id(sortByLowestPriceFirstOption), WaitStrategy.CLICKABLE, "Sort by Price: Lowest First option");
		return this;
	}

}
