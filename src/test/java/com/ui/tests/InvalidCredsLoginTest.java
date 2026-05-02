package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners({ com.ui.listners.TestListener.class })
public class InvalidCredsLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "nithin@gmail.com";
	private static final String INVALID_PASSWORD = "nithin@1233";

	@Test(description = "Verify Invalid user able to login to the application using excel", groups = { "smoke",
			"e2e","sanity" },retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void loginExcelTest() {

		logger.info("Started my login excel test");
		String errormsg = homePage.goToLoginPage().doLoginWithInvalidCredential(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage();
		assertEquals(errormsg, "Authentication failed.");
		logger.info("login excel test completed");

	}

}
