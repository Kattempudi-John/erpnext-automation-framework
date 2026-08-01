package com.erpTechnologies.pages;

import com.erpTechnologies.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected Logger logger;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = LogManager.getLogger(this.getClass());

        logger.info("BasePage initialized successfully.");
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void click(By locator, String elementName) {
        try {

            logger.info("Waiting until element '{}' becomes clickable.", elementName);

            wait.until(ExpectedConditions.elementToBeClickable(locator));

            WebElement element = driver.findElement(locator);

            logger.info("Clicking on element '{}'.", elementName);

            element.click();

            logger.info("Element '{}' clicked successfully.", elementName);

        } catch (Exception e) {

            logger.error("Failed to click element '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "Click_" + elementName);

            throw new RuntimeException(
                    "Failed to click element: " + elementName,
                    e
            );
        }
    }

    protected void type(By locator, String text, String elementName) {
        try {

            logger.info("Waiting until element '{}' becomes visible.", elementName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            WebElement element = driver.findElement(locator);

            logger.info("Clearing existing text from '{}'.", elementName);

            element.clear();

            logger.info("Entering text into '{}'.", elementName);

            element.sendKeys(text);

            logger.info("Text entered successfully into '{}'.", elementName);

        } catch (Exception e) {

            logger.error("Failed to enter text into '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "Type_" + elementName);

            throw new RuntimeException(
                    "Failed to enter text into: " + elementName,
                    e
            );
        }
    }

    protected String getText(By locator, String elementName) {
        try {

            logger.info("Waiting until element '{}' becomes visible.", elementName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            WebElement element = driver.findElement(locator);

            logger.info("Retrieving text from '{}'.", elementName);

            String text = element.getText();

            logger.info("Retrieved text from '{}': {}", elementName, text);

            return text;

        } catch (Exception e) {

            logger.error("Failed to retrieve text from '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "GetText_" + elementName);

            throw new RuntimeException(
                    "Failed to retrieve text from: " + elementName,
                    e
            );
        }
    }

    protected boolean isDisplayed(By locator, String elementName) {
        try {

            logger.info("Waiting until element '{}' becomes visible.", elementName);

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            WebElement element = driver.findElement(locator);

            logger.info("Checking whether '{}' is displayed.", elementName);

            boolean displayed = element.isDisplayed();

            logger.info("Element '{}' displayed status: {}", elementName, displayed);

            return displayed;

        } catch (Exception e) {

            logger.error("Failed to verify visibility of '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "IsDisplayed_" + elementName);

            throw new RuntimeException(
                    "Failed to verify visibility of: " + elementName,
                    e
            );
        }
    }
}


