package com.erpTechnologies.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.erpTechnologies.drivers.DriverManager;
import com.erpTechnologies.reports.ExtentTestManager;
import com.erpTechnologies.reports.ReportManager;
import com.erpTechnologies.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result){

        ExtentTest extentTest =
                ReportManager.getExtentReports()
                        .createTest(result.getMethod().getMethodName());

        logger.info("Creating ExtentTest for: {}",
                result.getMethod().getMethodName());

        ExtentTestManager.setTest(extentTest);
    }

    public void onTestSuccess(ITestResult result){
        ExtentTestManager.getTest().pass("Test Passed");

        logger.info("Test Passed: {}",
                result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {

        ReportManager.getExtentReports().flush();

        ExtentTestManager.removeTest();

        logger.info("Extent report generated successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed: {}", result.getMethod().getMethodName());

        WebDriver driver = DriverManager.getDriver();

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .fail(result.getThrowable());

        ExtentTestManager.getTest()
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("Test Skipped: {}",
                result.getMethod().getMethodName());

        ExtentTestManager.getTest().skip(result.getThrowable());
    }
}
