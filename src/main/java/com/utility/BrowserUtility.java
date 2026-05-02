package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
	private WebDriverWait wait;

//	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	protected BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
	}

	protected BrowserUtility(String browserName) {

		logger.info("Launching Browser for: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		} else {
			logger.error("Invalid Browser Name...Please select chrome or edge only!!");
			System.err.println("Invalid Browser Name...Please select chrome or edge only!!");
		}
	}

	protected BrowserUtility(Browser browserName) {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		logger.info("Launching Browser for: " + browserName);
		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		} else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		}
	}

	protected BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Launching Browser for: " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--headless=old");
				op.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(op));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions op = new EdgeOptions();
				op.addArguments("--headless=old");
				op.addArguments("--disable-gpu");
				op.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(op));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			}
		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions op = new FirefoxOptions();
				op.addArguments("--headless=old");
				op.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(op));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
			}

		}
	}

	public void goToWebSite(String url) {
		logger.info("Visiting the website: " + url);
		driver.get().get(url);

	}

	public void maximizeWindow() {
		logger.info("Maximizing browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By by) {
		logger.info("Finding element with locator: " + by);
//		WebElement ele = driver.get().findElement(by);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(by));
		logger.info("Element found and now performing the click");
		ele.click();
	}

	public void clickOnCheckBox(By by) {
		logger.info("Finding element with locator: " + by);
//		WebElement ele = driver.get().findElement(by);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		logger.info("Element found and now performing the click");
		ele.click();
	}

//	public void clickOnWithScroll(By by) {
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		logger.info("Finding element with locator " + by);
//
//		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(by));
//
//		// Scroll into view before waiting for clickability
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
//
//		// Now wait until clickable
//		ele = wait.until(ExpectedConditions.elementToBeClickable(by));
//
//		logger.info("Element found and now performing the click");
//		try {
//			ele.click();
//		} catch (Exception e) {
//			logger.warn("Standard click failed, attempting JS click", e);
//			js.executeScript("arguments[0].click();", ele);
//		}
//	}

	public void scrollToElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		logger.info("Finding element with locator: " + by);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(by));

		logger.info("Scrolling into the element: " + by);
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		logger.info("Scrolled into the element and proceeding  with the next operation");

	}

	public void clickOn(WebElement ele) {
		logger.info("Finding element and clicking");
		ele.click();
	}

	public void enterSpecialKey(By by, Keys keyToEnter) {
		logger.info("Finding element with locator: " + by);
		WebElement ele = driver.get().findElement(by);
		logger.info("Element found and entered text: " + keyToEnter);
		ele.sendKeys(keyToEnter);

	}

	public void enterText(By by, String textToEnter) {
		logger.info("Finding element with locator: " + by);
//		WebElement ele = driver.get().findElement(by);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		logger.info("Element found and entered text: " + textToEnter);
		ele.sendKeys(textToEnter);

	}

	public void clearText(By by) {
		logger.info("Finding element with locator: " + by);
//		WebElement ele = driver.get().findElement(by);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		logger.info("Element found and clearing the text box field");
		ele.clear();

	}

	public String getVisibleText(By by) {
		logger.info("Finding element with locator: " + by);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		WebElement ele = driver.get().findElement(by);
		logger.info("Returning the visible text: " + ele.getText());
		return ele.getText();

	}

	public String getVisibleText(WebElement ele) {

		logger.info("Returning the visible text: " + ele.getText());
		return ele.getText();

	}

	public List<String> getAllVisibleText(By by) {

		logger.info("Finding element with locator: " + by);
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		logger.info("Printing the list of elements");
		List<String> visibleTextList = new ArrayList<>();
		for (WebElement ele : elementList) {
			String text = getVisibleText(ele);
			visibleTextList.add(text);

		}

		return visibleTextList;

	}

	public List<WebElement> getAllElements(By by) {

		logger.info("Finding element with locator: " + by);
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		logger.info("returning the list of elements");

		return elementList;

	}

//	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
//		logger.info("Finding element with locator " + dropDownLocator);
//		WebElement ele = driver.get().findElement(dropDownLocator);
//		Select select = new Select(ele);
//		logger.info("Selecting the option: " + optionToSelect);
//		select.selectByVisibleText(optionToSelect);
//
//	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		logger.info("Finding element with locator: " + dropDownLocator);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(dropDownLocator));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Select select = new Select(ele);
		logger.info("Selecting the option: " + optionToSelect);

		List<WebElement> options = select.getOptions();

		for (WebElement op : options) {
//			System.out.println(op.getText());
			if (op.getText().equalsIgnoreCase(optionToSelect)) {
				op.click();
				break;
			}

		}

//		select.selectByVisibleText(optionToSelect);

	}

	public String takesScreenshot(String fileName) {
		TakesScreenshot screenShot = (TakesScreenshot) getDriver();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		String timeStamp = dateFormat.format(date);

		String destPath = "./screenshots" + File.separator + fileName + "_" + timeStamp + ".png";
		File screenShotFile = new File(destPath);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return destPath;
	}

	public void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}

	}
}
