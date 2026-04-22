package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	HomePage homePage;

	@BeforeMethod(description = "Load the Home Page of the Website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}


	@Test(description = "Verify valid user able to login to the application", groups = { "smoke", "e2e" })
	public void loginTest() {

		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";

		String userName = homePage.goToLoginPage().doLoginWith(email, password).getUserName();
		assertEquals(userName,"Nithin P");

	}

}
