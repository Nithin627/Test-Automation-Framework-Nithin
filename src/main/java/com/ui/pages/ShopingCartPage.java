package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShopingCartPage extends BrowserUtility {
	private static final By PROCEED_TO_CHECK_OUT_BTN_LOCATOR = By
			.xpath("//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

	protected ShopingCartPage(WebDriver driver) {
		super(driver);

	}

	public ConfirmAddressPage goToConfirmAddressPage() {
		scrollToElement(PROCEED_TO_CHECK_OUT_BTN_LOCATOR);
		clickOn(PROCEED_TO_CHECK_OUT_BTN_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}

}
