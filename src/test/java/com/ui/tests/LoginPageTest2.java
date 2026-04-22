package com.ui.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class LoginPageTest2 {
	WebDriver driver;
	WebDriverWait wait;

	@Test(description = "Login with valid credentials!!")
	public void loginTest() {
		By signInBtnLocator = By.id("SubmitLogin");
		By loginBtnLocator = By.cssSelector(".login");
		By userNameLocator = By.id("email");
		By passwordLocator = By.id("passwd");
		By logOutBtnLocator = By.cssSelector("a.logout");

		String email = "yatese2929@mugstock.com";
		String password = "nithin@123";

		driver = new ChromeDriver();

//		BrowserUtility browserUtility = new BrowserUtility(driver);
//		browserUtility.goToWebSite("https://automationpractice.techwithjatin.com/");
//		browserUtility.maximizeWindow();
//
//		browserUtility.clickOn(loginBtnLocator);
//
//		browserUtility.enterText(userNameLocator, email);
//		browserUtility.enterText(passwordLocator, password);
//		browserUtility.clickOn(signInBtnLocator);
//
//		browserUtility.clickOn(logOutBtnLocator);

	}

}
