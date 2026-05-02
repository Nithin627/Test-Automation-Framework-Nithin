package com.ui.tests;

import static com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
//	private boolean isHeadless;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Loads the Home Page of the Website")
	public void setUp(@Optional("chrome") String browser, @Optional("true") boolean isLambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			// Running the test in local machine
			logger.info("Loads the Home Page of the Website");
			homePage = new HomePage(EDGE, isHeadless); // setup browser name and isHeadLess true/false
//			homePage= new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}

	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LamdaTestUtility.quitSession();// quit the driver session in lambda test
		} else {
			homePage.quitDriver();
		}

	}

	public BrowserUtility getInstances() {
		return homePage;
	}
}
