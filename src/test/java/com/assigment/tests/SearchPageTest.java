package com.assigment.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.assignment.annotations.FrameworkAnnotations;
import com.assignment.enums.CategoryType;
import com.assignment.pages.HomePage;
import com.assignment.pages.SearchPage;
import com.assignment.utilities.SortingUtilities;

/**
 * This is a child class extending the parent BaseTest class.
 * It contains the tests related to Search page.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */
public final class SearchPageTest extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private SearchPageTest() {}

	/**
	 * Verifies whether required pop-up is shown on clicking the buttons (Quick View, Add to Cart, Add to Wishlist)
	 * within the product container.
	 * 
	 * Keyword, product element, replacing value mentioned here should match the column names "keyword",
	 * "productElement", "replacingValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifyPopUpIsShownOnClickingProdContainerBtnTest_TC_004(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.checkSearchBreadCrumbIsDisplayed()).isTrue();

		searchPLP.clickProductContainerButton(data.get("productElement"));
		assertThat(searchPLP.checkPopUpOrPDPIsDisplayed(data.get("replacingValue")))
				.withFailMessage("Required popup is not displayed").isTrue();
	} 

	/**
	 * Verifies whether Product Description Page is displayed on clicking the given product element links (More, Image, Colour)
	 * 
	 * Keyword, product element, replacing value mentioned here should match the column names "keyword",
	 * "productElement", "replacingValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifyProductDescriptionPageIsDisplayedTest_TC_005(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.checkSearchBreadCrumbIsDisplayed()).isTrue();

		searchPLP.clickProductElementLink(data.get("replacingValue"), data.get("productElement"));
		assertThat(searchPLP.checkPopUpOrPDPIsDisplayed(data.get("replacingValue")))
				.withFailMessage("Required PDP is not displayed").isTrue();
	} 

	/**
	 * Verifies whether the required fields (Sort By Option, Left Hand Side Container) are shown on the Search Results page
	 * 
	 * Keyword, search page field, replacing value mentioned here should match the column names "keyword",
	 * "searchPageField", "replacingValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifySearchPageFieldIsDisplayedTest_TC_008(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.checkSearchPageFieldIsDisplayed(data.get("replacingValue"), data.get("searchPageField")))
				.withFailMessage("Required field is not present on the Search page").isTrue();
	} 

	/**
	 * Verifies whether the search results are displayed in the selected (grid, list) view
	 * 
	 * Keyword, property name, replacing value, attribute value mentioned here should match the column names "keyword",
	 * "propertyName", "replacingValue", "attributeValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifyRequiredSearchPageViewIsSelectedTest_TC_007(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.getViewAttributeValue(data.get("replacingValue"), data.get("propertyName")))
		.isEqualTo(data.get("attributeValue"));
	}

	/**
	 * Verifies whether the searched results are sorted as per the selected Name Sort By option
	 * 
	 * Keyword, sort by option, replacing value mentioned here should match the column names "keyword",
	 * "sortByOption", "replacingValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifySearchedProductsAreSortedByNameTest_TC_006(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn().clickOnSortByOption()
				.clickOnTheRequiredSortOption(data.get("replacingValue"), data.get("sortByOption"));

		List<String> actualSortedProductsByNameAsOnSearchPage = searchPLP.getSearchedProductsByName(data.get("keyword"));
		List<String> expectedSortedProductsByName = SortingUtilities.getExpectedSortedProductsByName(data.get("sortByOption"), 
				actualSortedProductsByNameAsOnSearchPage);

		assertThat(actualSortedProductsByNameAsOnSearchPage)
				.withFailMessage(() -> String.format("Actual sorted products %s1% are not equal to the expected sorted products %s2%", 
						actualSortedProductsByNameAsOnSearchPage, expectedSortedProductsByName))
				.isEqualTo(expectedSortedProductsByName);
	}

	/**
	 * Verifies whether the searched results are sorted as per the selected Price Sort By option
	 * 
	 * Keyword, sort by option, replacing value mentioned here should match the column names "keyword",
	 * "sortByOption", "replacingValue" respectively in the excel sheet. It is mandatory to run this test.
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
	public void verifySearchedProductsAreSortedByPriceTest_TC_006(Map<String, String> data) {

		SearchPage searchPLP = new HomePage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn().clickOnSortByOption()
				.clickOnTheRequiredSortOption(data.get("replacingValue"), data.get("sortByOption"));

		List<Integer> actualSortedProductsByPriceAsOnSearchPage = searchPLP.getSearchedProductsByPrices(data.get("sortByOption"))
				.stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> expectedSortedProductsByPrice = SortingUtilities.getExpectedSortedProductsByPrice(data.get("sortByOption"), 
				actualSortedProductsByPriceAsOnSearchPage);

		assertThat(actualSortedProductsByPriceAsOnSearchPage)
				.withFailMessage(() -> String.format("Actual sorted products %s1% are not equal to the expected sorted products %s2%", 
						actualSortedProductsByPriceAsOnSearchPage, expectedSortedProductsByPrice))
				.isEqualTo(expectedSortedProductsByPrice);

	}

}
