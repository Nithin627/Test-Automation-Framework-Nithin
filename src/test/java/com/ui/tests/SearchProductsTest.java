package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listners.TestListener.class })
public class SearchProductsTest extends TestBase {
	private MyAccountPage myyAccountPage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String SEARCH_TERM = "Printed Summer Dress";
	private static final String SEARCH_TERM2 = "Mens walet";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setUp() {
		myyAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("yatese2929@mugstock.com", "nithin@123");
	}

	@Test(description = "Verify loged in user able to search for a product and correct products serach are displayed", groups = {
			"e2e", "smoke" }, retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void verifyProductSearch() {
//		String data = myyAccountPage.searchForProducts("Printed Summer Dress").getSearchResultTitle();
//		Assert.assertEquals(data, "PRINTED SUMMER DRESS1");// Failing the test
//		System.out.println(data);

		boolean actualResult = myyAccountPage.searchForProducts(SEARCH_TERM)
				.isSerachtermPresentInProductList(SEARCH_TERM);
		Assert.assertTrue(actualResult);
	}

}
