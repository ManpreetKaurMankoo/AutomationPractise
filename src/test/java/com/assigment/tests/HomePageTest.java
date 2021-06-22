package com.assigment.tests;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

import com.assignment.annotations.FrameworkAnnotations;
import com.assignment.enums.CategoryType;
import com.assignment.pages.HomePage;
import com.assignment.pages.SearchPage;

/**
 * This is a child class extending the parent BaseTest class.
 * It contains the tests related to Home page.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class HomePageTest extends BaseTest {								

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private HomePageTest(){													
	}

	/**
	 * Verifies whether all the products related to the searched product name are only displayed
	 * 
	 * Keyword mentioned here should match the column name "keyword" in the excel sheet. It is mandatory to run this test.
	 * Otherwise it will be ignored.
	 * The match has to be there in both of the TestInformation and SearchData sheets.
	 * 
	 * Set the authors who have the created the test which will be logged to the reports
	 * Set the category which this particular test case belongs to
	 * 
	 * @param data
	 * HashMap containing all the values of test data needed to run the tests
	 * 
	 */
	
	@FrameworkAnnotations(author={"Manpreet"}, category= {CategoryType.FUNCTIONAL, CategoryType.SMOKE})
	@Test()
	public void verifySearchedProductsWithProductNameTest_TC_001(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.checkSearchBreadCrumbIsDisplayed()).isTrue();

		List<String> productsFetchedBySearch = searchPLP.getSearchedProductsByName(data.get("keyword"));
		List<String> productsRelatedToTheSearchOnly = searchPLP.getProductsRelatedToTheSearchOnly(data.get("keyword"));

		assertThat(productsFetchedBySearch)
				.withFailMessage("All the expected searched products were supposed to be related to the searched product only but were not")
				.isEqualTo(productsRelatedToTheSearchOnly);

	}

	/**
	 * Verifies whether the searched product's image and price are shown in the search results
	 * 
	 * Keyword , product element mentioned here should match the column names "keyword", "productElement" in the excel sheet.
	 * It is mandatory to run this test. Otherwise it will be ignored.
	 * The match has to be there in both of the TestInformation and SearchData sheets.
	 * 
	 * Set the authors who have the created the test which will be logged to the reports
	 * Set the category which this particular test case belongs to
	 * 
	 * @param data
	 * HashMap containing all the values of test data needed to run the tests
	 */
	
	@FrameworkAnnotations(author={"Manpreet"}, category= {CategoryType.FUNCTIONAL, CategoryType.SMOKE})
	@Test()
	public void verifyProductElementsAreDisplayedTest_TC_003(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();

		SearchPage productElementCount = searchPLP.getProductPriceImageCount(data.get("productElement"));

		assertThat(productElementCount)
				.withFailMessage(()-> String.format("Expected no. of product element count %s is not equal to product count %s",
						productElementCount, searchPLP.getSearchedProductsCount()))
				.isEqualTo(searchPLP.getSearchedProductsCount());
	}

	/**
	 * Verifies whether the auto suggestion is displayed and suggests only related products as per the keyword entered
	 * 
	 * Keyword mentioned here should match the column name "keyword" in the excel sheet. It is mandatory to run this test.
	 * Otherwise it will be ignored.
	 * The match has to be there in both of the TestInformation and SearchData sheets.
	 * 
	 * Set the authors who have the created the test which will be logged to the reports
	 * Set the category which this particular test case belongs to
	 * 
	 * @param data
	 * HashMap containing all the values of test data needed to run the tests
	 */
	
	@FrameworkAnnotations(author={"Manpreet"}, category= {CategoryType.FUNCTIONAL, CategoryType.SMOKE})
	@Test()
	public void verifyAutoSuggestionAndRelatedProductsTest_TC_009(Map<String, String> data) {

		HomePage homePLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"));

		assertThat(homePLP.checkAutoSuggestionIsDisplayed())
				.withFailMessage("Auto Suggestion took too long to be displayed").isTrue();
		assertThat(homePLP.getAllTheSuggestedProducts().stream().map(value -> !value.contains(data.get("keyword")))
				.collect(Collectors.toList()).size()>0)
				.withFailMessage("Some of the auto suggested products are not related to the given keyword")
				.isFalse();
	}
}
