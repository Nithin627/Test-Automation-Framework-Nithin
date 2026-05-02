package com.ui.pages;

import static com.constants.Env.*;
import static com.utility.JsonUtility.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

//import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector(".login");
	

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebSite(readJSON(QA).getUrl());
		maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(readJSON(QA).getUrl());
		maximizeWindow();

	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());

	}



}
