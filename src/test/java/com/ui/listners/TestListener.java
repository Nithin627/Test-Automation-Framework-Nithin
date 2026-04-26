package com.ui.listners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.maven.doxia.logging.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started..!!");
		ExtentReportUtility.setUpSparkReporter("extentReport.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed..!!");
		ExtentReportUtility.flushReport();

	}

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testClass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase) testClass).getInstances();
		
		logger.info("Capturing ScreenShot for the failed test");
		String screenShotPath = browserUtility.takesScreenshot(result.getMethod().getMethodName());
		
		logger.info("Attaching ScreenShot to the HTML file");
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenShotPath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");

	}

}
