package com.assigment.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.assignment.annotations.FrameworkAnnotations;
import com.assignment.enums.CategoryType;
import com.assignment.pages.HomePage;
import com.assignment.pages.SearchPage;

/**
 * This is a child class extending the parent BaseTest class.
 * It contains the tests related to Dress page.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class DressPageTest extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private DressPageTest() {
	}

	/**
	 * Verifies whether the searched products are related to the given category, sub-category, or sub-category type
	 * 
	 * Keyword, index, product type mentioned here should match the column names "keyword", "index", "productType" respectively
	 * in the excel sheet. It is mandatory to run this test.
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
	public void verifySearchedProductsWithProductTypeTest_TC_002(Map<String, String> data) {

		List<String> productsFetchedByProductType = new HomePage()
				.clickProductTypePage(data.get("keyword"), data.get("index"))
				.getAllDressesNames();

		SearchPage searchPLP = new SearchPage()
				.clearSearchField()
				.enterSearchKeyword(data.get("keyword"))
				.clickSearchBtn();
		assertThat(searchPLP.checkSearchBreadCrumbIsDisplayed()).isTrue();

		List<String> productsFetchedBySearch = searchPLP.getSearchedProductsByName(data.get("productType"));
		
		assertThat(productsFetchedBySearch)
			.withFailMessage("All the expected searched products were supposed to be related to the searched product type only but were not")
			.isEqualTo(productsFetchedByProductType);

	}
}
