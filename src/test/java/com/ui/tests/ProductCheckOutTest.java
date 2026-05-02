package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultsPage;

public class ProductCheckOutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultsPage searchResultPage;

	@BeforeMethod(description = "Valid user logs into the application and searches for a product")
	public void setUp() {
		searchResultPage = homePage.goToLoginPage().doLoginWithValidCredentials("yatese2929@mugstock.com", "nithin@123")
				.searchForProducts(SEARCH_TERM);
	}

	@Test(description = "Verify a logged in user able to buy a dress", groups = { "e2e", "smoke", "sanity" })
	public void checkOutTest() {
		String alertMsg = searchResultPage.clickOnTheProductAtIndex(1).changeSize(L).clckOnAddToCartBtn()
				.proceedToheckOutBtn().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().getTheAlertMsg();

		Assert.assertTrue(alertMsg.contains("No payment modules"));
//		Assert.assertEquals(alertMsg, "No payment modules have been installed.");

	}

}
