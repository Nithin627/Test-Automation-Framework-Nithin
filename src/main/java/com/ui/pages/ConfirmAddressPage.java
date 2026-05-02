package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {
	private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR = By.xpath("//button[@name='processAddress']");

	protected ConfirmAddressPage(WebDriver driver) {
		super(driver);

	}

	public ShippingPage goToShipmentPage() {
		scrollToElement(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
		return new ShippingPage(getDriver());
	}

}
