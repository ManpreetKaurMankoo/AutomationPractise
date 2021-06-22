package com.assignment.utilities;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility to sort the products on the basis of product names and product prices
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 */

public final class SortingUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private SortingUtilities() {

	}

	/**
	 * Takes a list of product names and sorts them in ascending or descending order
	 * 
	 * @param sortByOption
	 * Sort option on which the product names are to be sorted on
	 * 
	 * @param actualSortedProductsByNameAsOnSearchPage
	 * List of product names in the order as obtained from sorting on the Search page
	 * 
	 * @return a list of product names sorted by ascending or descending order as per the sortByOption
	 */
	
	public static List<String> getExpectedSortedProductsByName(String sortByOption, List<String> actualSortedProductsByNameAsOnSearchPage) {
		String sortByNameOption1 = "Product name from A to Z";
		if(sortByOption.equalsIgnoreCase(sortByNameOption1))
			return actualSortedProductsByNameAsOnSearchPage.stream().sorted().collect(Collectors.toList());
		else
			return actualSortedProductsByNameAsOnSearchPage.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	/**
	 * Takes a list of product prices and sorts them in ascending or descending order
	 * 
	 * @param sortByOption
	 * Sort option on which the product prices are to be sorted on
	 * 
	 * @param actualSortedProductsByPriceAsOnSearchPage
	 * List of product prices in the order as obtained from sorting on the Search page
	 * 
	 * @return a list of product prices sorted by ascending or descending order as per the sortByOption
	 */
	
	public static List<Integer> getExpectedSortedProductsByPrice(String sortByOption, List<Integer> actualSortedProductsByPriceAsOnSearchPage) {
		String sortByPriceOption1 = "Lowest price first";
		if(sortByOption.equalsIgnoreCase(sortByPriceOption1))
			return actualSortedProductsByPriceAsOnSearchPage.stream().sorted().collect(Collectors.toList());
		else
			return actualSortedProductsByPriceAsOnSearchPage.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

}
