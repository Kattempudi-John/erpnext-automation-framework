package com.erpTechnologies.tests;

import com.erpTechnologies.drivers.DriverFactory;
import com.erpTechnologies.drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    public void setUp(){
        logger.info("Test setup started.");
        DriverManager.setDriver(DriverFactory.initializeDriver());
        logger.info("Browser initialized successfully.");

    }

    @AfterMethod
    public void tearDown(){

        logger.info("Closing browser.");

        DriverManager.getDriver().quit();

        DriverManager.removeDriver();

        logger.info("Test teardown completed.");
    }
}
