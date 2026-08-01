package com.erpTechnologies.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final Logger logger =
            LogManager.getLogger(ScreenshotUtil.class);

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String fileName = testName + "_" + timestamp + ".png";

        File screenshotDirectory = new File("screenshots");

        if (!screenshotDirectory.exists()) {
            if (screenshotDirectory.mkdirs()) {
                logger.info("Screenshots directory created successfully.");
            }
        }
        File destinationFile = new File(screenshotDirectory, fileName);

        try {

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

            File sourceFile =
                    takesScreenshot.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(sourceFile, destinationFile);

            logger.info("Screenshot captured successfully: {}",
                    destinationFile.getAbsolutePath());

            return destinationFile.getAbsolutePath();

        } catch (IOException e) {

            logger.error("Failed to capture screenshot.", e);

            return null;
        }
    }
}
