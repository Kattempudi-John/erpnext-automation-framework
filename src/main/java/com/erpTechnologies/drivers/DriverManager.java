package com.erpTechnologies.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final Logger logger =
            LogManager.getLogger(DriverManager.class);

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
        logger.info("Driver instance stored successfully.");
    }

    public static WebDriver getDriver(){
        logger.debug("Retrieving driver instance.");
        return driver.get();
    }

    public static void removeDriver() {
        driver.remove();
        logger.info("Driver instance removed successfully.");
    }

}
