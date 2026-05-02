package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

import edu.emory.mathcs.backport.java.util.Arrays;

public class SearchResultsPage extends BrowserUtility {
	private static final By PRODUCT_LISTING_LOCATOR = By.cssSelector(".lighter");
	private static final By PRODUCTS_LIST_LOCATOR = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_LOCATOR);
	}

	public boolean isSerachtermPresentInProductList(String searchTerm) {
		List<String> keyWordList = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productName = getAllVisibleText(PRODUCTS_LIST_LOCATOR);
		boolean result = productName.stream()
				.anyMatch(name -> keyWordList.stream().anyMatch(name.toLowerCase()::contains));
		return result;
	}

	public ProductDetailPage clickOnTheProductAtIndex(int index) {

		List<WebElement> allElements = getAllElements(PRODUCTS_LIST_LOCATOR);
		clickOn(allElements.get(index));
		return new ProductDetailPage(getDriver());

	}
}
