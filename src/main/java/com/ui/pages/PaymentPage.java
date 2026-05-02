package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By ALERT_WARNING_MSG_LOCATOR = By.xpath("//p[contains(@class,'alert-warning')]");
	private static final By PAYMENT_BY_WIRE_BTN_LOCATOR = By.xpath("");
	private static final By CONFIRM_ORDER_BTN_LOCATOR = By.xpath("");
	private static final By ALERT_SUCCESS_MSG_LOCATOR = By.xpath("");

	protected PaymentPage(WebDriver driver) {
		super(driver);

	}

	public String getTheAlertMsg() {
		return getVisibleText(ALERT_WARNING_MSG_LOCATOR);
	}

	public String makePaymentByWire() {
		clickOn(PAYMENT_BY_WIRE_BTN_LOCATOR);
		clickOn(CONFIRM_ORDER_BTN_LOCATOR);
		return getVisibleText(ALERT_SUCCESS_MSG_LOCATOR);
	}

}
