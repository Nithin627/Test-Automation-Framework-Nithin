package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.Users;
import com.utility.LoggerUtility;


@Listeners({ com.ui.listners.TestListener.class })
public class LoginTest extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	

//	@Test(description = "Verify valid user able to login to the application using json", groups = { "smoke",
//			"e2e" }, dataProvider = "loginTestJSONDataProvider", dataProviderClass = com.ui.DataProviders.LoginDataprovider.class, retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
//	public void loginJsonTest(Users user) {
//
////		String email = "yatese2929@mugstock.com";
////		String password = "nithin@123";
//
//		logger.info("Started my login JSON test");
//		String userName = homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName();
//		assertEquals(userName, "Nithin Ps");
//		logger.info("login JSON test completed");
//
//	}
//
//	@Test(description = "Verify valid user able to login to the application using csv", groups = { "smoke",
//			"e2e" }, dataProvider = "loginTestCSVDataProvider", dataProviderClass = com.ui.DataProviders.LoginDataprovider.class, retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
//	public void loginCSVTest(Users user) {
//
//		String userName = homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName();
//		assertEquals(userName, "Nithin P");
//
//	}

	@Test(description = "Verify valid user able to login to the application using excel", groups = { "smoke",
			"e2e" }, dataProvider = "loginTestExcelDataProvider", dataProviderClass = com.ui.DataProviders.LoginDataprovider.class, retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void loginExcelTest(Users user) {

		logger.info("Started my login excel test");
		String userName = homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPassword()).getUserName();
		assertEquals(userName, "Nithin P");
		logger.info("login excel test completed");

	}

}
