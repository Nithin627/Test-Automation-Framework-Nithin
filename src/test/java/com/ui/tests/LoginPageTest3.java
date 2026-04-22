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
		HomePage homePage = new HomePage(CHROME);

		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith(email, password);

	}

	@Test(description = "Login with valid credentials with chaining!!")
	public void loginTest2() {

		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";
		
		HomePage homePage = new HomePage(CHROME);
		String userName = homePage.goToLoginPage().doLoginWith(email, password).getUserName();
		System.out.println(userName);

	}

}
