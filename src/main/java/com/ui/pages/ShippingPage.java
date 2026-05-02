package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {
	private static final By AGREE_TO_TERMS_CHECK_BOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR = By.xpath("//button[@name='processCarrier']");

	protected ShippingPage(WebDriver driver) {
		super(driver);

	}

	public PaymentPage goToPaymentPage() {
		clickOnCheckBox(AGREE_TO_TERMS_CHECK_BOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
