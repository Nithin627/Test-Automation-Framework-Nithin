package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By USER_EMAIL_LOCATOR = By.id("email");
	private static final By USER_PASSWORD_LOCATOR = By.id("passwd");
	private static final By LOGIN_BTN_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage doLoginWith(String email, String password) {
		enterText(USER_EMAIL_LOCATOR, email);
		enterText(USER_PASSWORD_LOCATOR, password);
		clickOn(LOGIN_BTN_LOCATOR);
		return new MyAccountPage(getDriver());
	}

}
