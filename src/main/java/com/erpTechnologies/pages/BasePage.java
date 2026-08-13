package com.erpTechnologies.pages;

import com.erpTechnologies.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

            WebElement element =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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

            WebElement element =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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

            WebElement element =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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

    protected void selectByVisibleText(By locator, String visibleText, String elementName) {

        try {

            logger.info("Waiting until '{}' becomes clickable.", elementName);

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            Select select = new Select(element);

            logger.info("Selecting '{}' from '{}'.", visibleText, elementName);

            select.selectByVisibleText(visibleText);

            logger.info("Successfully selected '{}' from '{}'.", visibleText, elementName);

        } catch (Exception e) {

            logger.error("Failed to select '{}' from '{}'.", visibleText, elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "SelectByVisibleText_" + elementName);

            throw new RuntimeException(
                    "Failed to select '" + visibleText + "' from '" + elementName + "'", e
            );
        }
    }

    protected void selectCustomDropdown(
            By inputLocator,
            By optionLocator,
            String value,
            String fieldName
    ){
        try{

            logger.info("Waiting for '{}' custom dropdown.", fieldName);
            WebElement input =
                   wait.until(ExpectedConditions.elementToBeClickable(inputLocator));

            logger.info("Clicking '{}' custom dropdown.", fieldName);

            input.click();

            logger.info("Clearing existing value from '{}'.", fieldName);
            input.sendKeys(Keys.chord(Keys.CONTROL, "a"));

            logger.info("Typing '{}' into '{}'.", value, fieldName);

            input.sendKeys(Keys.DELETE);

            input.sendKeys(value);

            logger.info("Waiting for '{}' option '{}' to become clickable.", fieldName, value);

            WebElement option =
                   wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

            logger.info("Selecting '{}' from '{}'.", value, fieldName);

            option.click();

            logger.info("'{}' selected successfully in '{}'.", value, fieldName);

        } catch (Exception e) {

            logger.error("Failed to select '{}' from '{}'.", value, fieldName, e);

            ScreenshotUtil.captureScreenshot(driver, "Select_Customer_Dropdown_" + fieldName);

            throw new RuntimeException(
                    "Failed to select '" + value + "' from '" + fieldName + "' custom dropdown.", e);
        }
    }
    protected boolean isDisplayed(By locator, String elementName) {
        try {

            logger.info("Waiting until element '{}' becomes visible.", elementName);

            WebElement element =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            return element.isDisplayed();

        } catch (Exception e) {

            logger.error("Failed to verify visibility of '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "IsDisplayed_" + elementName);

            throw new RuntimeException(
                    "Failed to verify visibility of: " + elementName,
                    e
            );
        }

    }

    protected void pressEnter(By locator, String elementName){

        try {

            logger.info("Waiting until element '{}' becomes visible.", elementName);

            WebElement element =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.sendKeys(Keys.ENTER);

            logger.info("Pressed ENTER on '{}'.", elementName);

        } catch (Exception e) {

            logger.error("Failed to press ENTER on '{}'.", elementName, e);

            ScreenshotUtil.captureScreenshot(driver, "pressEnter_" + elementName);

            throw new RuntimeException
                    ("Filed to Enter the Key" + elementName +
                    e);
        }

    }
    protected boolean isMissingFieldDisplayed(By locator, String fieldName){

        try{

            logger.info("Retrieving text from '{}'.", fieldName);

            String message = getText(
                    locator, "Missing value Message"
            );

            return message
                    .contains(fieldName);


        }catch (Exception e){

            logger.error("Failed to finding missing field '{}'.", fieldName, e);

            ScreenshotUtil.captureScreenshot(driver, "missingField_" + fieldName);

            throw new RuntimeException
                    ("Failed to finding missing field" + fieldName +
                            e);
        }
    }
}


