package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	protected BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	protected BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.err.println("Invalid Browser Name...Please select chrome or edge only!!");
		}
	}

	protected BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		} else if (browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
	}

	public void goToWebSite(String url) {

		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void clickOn(By by) {
		driver.findElement(by).click();
	}

	public void enterText(By by, String textToEnter) {
		driver.findElement(by).sendKeys(textToEnter);
	}

	public String getVisibleText(By by) {
		return driver.findElement(by).getText();
	}
}
