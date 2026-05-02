package com.ui.tests;

import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginPageTest3 {

//	@Test(description = "Login with valid credentials!!")
	public void loginTest() {

		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";

//		WebDriver driver = new ChromeDriver();
		HomePage homePage = new HomePage(CHROME, true);

		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWithValidCredentials(email, password);

	}

	@Test(description = "Login with valid credentials with chaining!!")
	public void loginTest2() {

		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";

		HomePage homePage = new HomePage(CHROME, true);
		String userName = homePage.goToLoginPage().doLoginWithValidCredentials(email, password).getUserName();
		System.out.println(userName);

	}

}
