package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

//	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	protected BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	protected BrowserUtility(String browserName) {
		logger.info("Launching Browser for: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid Browser Name...Please select chrome or edge only!!");
			System.err.println("Invalid Browser Name...Please select chrome or edge only!!");
		}
	}

	protected BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for: " + browserName);
		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
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
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions op = new EdgeOptions();
				op.addArguments("--headless=old");
				op.addArguments("--disable-gpu");
				op.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(op));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions op = new FirefoxOptions();
				op.addArguments("--headless=old");
				op.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(op));
			} else {
				driver.set(new FirefoxDriver());
			}

		}
	}

	public void goToWebSite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);

	}

	public void maximizeWindow() {
		logger.info("Maximizing browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By by) {
		logger.info("Finding element with locator " + by);
		WebElement ele = driver.get().findElement(by);
		logger.info("Element found and now performing the click");
		ele.click();
	}

	public void enterText(By by, String textToEnter) {
		logger.info("Finding element with locator " + by);
		WebElement ele = driver.get().findElement(by);
		logger.info("Element found and entered text " + textToEnter);
		ele.sendKeys(textToEnter);

	}

	public String getVisibleText(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		logger.info("Finding element with locator " + by);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		WebElement ele = driver.get().findElement(by);
		logger.info("Returning the visible text " + ele.getText());
		return ele.getText();

	}

	public String takesScreenshot(String fileName) {
		TakesScreenshot screenShot = (TakesScreenshot) getDriver();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		String timeStamp = dateFormat.format(date);

		String destPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + fileName
				+ "_" + timeStamp + ".png";
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
