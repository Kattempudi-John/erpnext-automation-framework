package com.erpTechnologies.listeners;

import com.erpTechnologies.drivers.DriverManager;
import com.erpTechnologies.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result){

        String testName = result.getMethod().getMethodName();

        logger.info("Test execution started: {}", testName);
    }

    public void onTestSuccess(ITestResult result){
        String testName = result.getMethod().getMethodName();

        logger.info("Test execution passed: {}", testName);
    }

    public void onTestFailure(ITestResult result){

        String testName = result.getMethod().getMethodName();

        Throwable throwable =
                result.getThrowable();

        logger.info("Test execution failed: {}", testName);

        if (throwable != null) {

            logger.error(
                    "Test execution failed: {}", testName, throwable
            );
        } else {

            logger.error("Test execution failed: {}. No exception details available.",
                    testName
            );
        }

        try{
            WebDriver driver = DriverManager.getDriver();

            if(driver != null){

                ScreenshotUtil.captureScreenshot(
                        driver,
                        "Failure_" + testName
                );
                logger.info("Failure screenshot capture for test: {}",testName);
            }else {

                logger.warn("Unable to capture screenshot for '{}'. WebDriver is null.", testName);
            }
        }catch (Exception e){
            logger.error(
                    "Failed to capture failure screenshot for test: {}", testName, e
            );
        }
    }

    public void onTestSkipped(ITestResult result){

        String testName = result.getMethod().getMethodName();

        logger.info("Test execution skipped: {}", testName);
    }

}
