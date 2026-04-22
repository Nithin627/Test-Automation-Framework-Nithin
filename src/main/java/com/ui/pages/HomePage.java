package com.ui.pages;

import static com.constants.Env.*;
import static com.utility.JsonUtility.*;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;

//import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector(".login");

	public HomePage(Browser browserName) {
		super(browserName);
//		goToWebSite(readProperty(QA, "URL"));
		goToWebSite(readJSON(QA));
	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());

	}

}
