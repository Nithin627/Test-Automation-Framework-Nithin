package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.Address;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS_TEXTBOX2_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By ZIP_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_NUMBER_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_NUMBER_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.cssSelector("#id_state");
	private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	protected AddressPage(WebDriver driver) {
		super(driver);

	}

//	public void saveAddress() {
//		enterText(COMPANY_TEXTBOX_LOCATOR, "ABC Company");
//		enterText(ADDRESS_TEXTBOX_LOCATOR, "Address line 1");
//		enterText(ADDRESS_TEXTBOX2_LOCATOR, "Address line 2");
//		enterText(CITY_TEXTBOX_LOCATOR, "City");
//		enterText(ZIP_CODE_TEXTBOX_LOCATOR, "57422");
//		enterText(HOME_PHONE_NUMBER_TEXTBOX_LOCATOR, "0802345");
//		enterText(MOBILE_NUMBER_TEXTBOX_LOCATOR, "9888888888");
//		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, "Other information");
//		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
//		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, "Home Address");
//		selectFromDropDownMe(STATE_DROPDOWN_LOCATOR, "California");
//
//	}

	public String saveAddress(Address address) {
		enterText(COMPANY_TEXTBOX_LOCATOR, address.getComanyName());
		enterText(ADDRESS_TEXTBOX_LOCATOR, address.getAddressLine1());
		enterText(ADDRESS_TEXTBOX2_LOCATOR, address.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, address.getCity());
		enterText(ZIP_CODE_TEXTBOX_LOCATOR, address.getPostCode());
		enterText(HOME_PHONE_NUMBER_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
		enterText(MOBILE_NUMBER_TEXTBOX_LOCATOR, address.getMobileNumber());
		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, address.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, address.getAddressAlias());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, address.getState());
		clickOn(SAVE_ADDRESS_LOCATOR);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;

	}
	


}
