package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.assignment.enums.WaitStrategy;

/**
 * Dress web page class for performing Selenium operations on Dress page WebElements
 * This class extends the BasePage class.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */
public final class DressPage extends BasePage {
	
	private String dressesList = "//*[@class='product_list grid row']//a[@class='product-name']";
	private String searchTextField = "search_query_top";
	private String searchButton = "submit_search";
	
	public List<String> getAllDressesNames() {
		return getTextOfAllElements(By.xpath(dressesList), WaitStrategy.VISIBLE, "All the products");
	}
	
	public DressPage clearSearchField() {
		clearText(By.id(searchTextField), WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}
	
	public DressPage enterSearchKeyword(String searchKeyword) {
		sendKeys(By.id(searchTextField), searchKeyword, WaitStrategy.CLICKABLE, "Search text field");
		return this;
	}
	
	public SearchPage clickSearchBtn() {
		click(By.name(searchButton), WaitStrategy.CLICKABLE, "Search button");
		return new SearchPage();
	}
	
}
