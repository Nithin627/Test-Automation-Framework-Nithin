package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BTN_LOACTOR = By.xpath("//button[@class='exclusive']");
	private static final By PROCEED_TO_CHECKOUt_BTN_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

	protected ProductDetailPage(WebDriver driver) {
		super(driver);

	}

	public ProductDetailPage changeSize(Size size) {
		selectFromDropDown(SIZE_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage clckOnAddToCartBtn() {
		clickOn(ADD_TO_CART_BTN_LOACTOR);
		return new ProductDetailPage(getDriver());
	}

	public ShopingCartPage proceedToheckOutBtn() {
		clickOn(PROCEED_TO_CHECKOUt_BTN_LOCATOR);
		return new ShopingCartPage(getDriver());
	}

}
