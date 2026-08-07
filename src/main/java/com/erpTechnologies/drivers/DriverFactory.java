package com.erpTechnologies.drivers;

import com.erpTechnologies.utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private static WebDriver driver;

    public static WebDriver initializeDriver() {

        logger.info("Initializing WebDriver...");

        String browser = ConfigReader.getProperty("browser");

        logger.info("Selected broswer: {}", browser);

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("{} browser launched successfully.", browser);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("{} browser launched successfully.", browser);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("{} browser launched successfully.", browser);
                break;

            default:
                logger.error("Invalid browser name provided: {}", browser);
                throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        logger.info("Browser window maximized.");

        driver.manage().deleteAllCookies();
        logger.info("Browser cookies deleted.");

        // Navigate to Application
        String url = ConfigReader.getProperty("base.url");
        driver.get(url);
        logger.info("Navigated to application URL: {}", url);

        return driver;
    }
}
