package com.ui.tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class LoginPageTest1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);

		driver.get("https://automationpractice.techwithjatin.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test(description = "Click SignIn Button", priority = 2)
	public void clickSignIn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		By signInBtnLocator = By.id("SubmitLogin");
		By loginBtnLocator = By.cssSelector(".login");

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();
	}

//	@Test(description = "Login with valid credentials!!", priority = 1)
	public void loginTest() {
		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		By userNameLocator = By.id("email");
		By passwordLocator = By.id("passwd");
		By signInBtnLocator = By.id("SubmitLogin");
		By loginBtnLocator = By.cssSelector("a.login");
		By logOutBtnLocator = By.cssSelector("a.logout");

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();

		String expected = driver.getTitle();
		String actual = "My account - Automation Practice";
		Assert.assertEquals(actual, expected);

		wait.until(ExpectedConditions.elementToBeClickable(logOutBtnLocator)).click();

	}

}
