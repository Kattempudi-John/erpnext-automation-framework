package com.erpTechnologies.tests;

import com.erpTechnologies.drivers.DriverFactory;
import com.erpTechnologies.drivers.DriverManager;
import com.erpTechnologies.workflows.AuthenticationWorkflow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.erpTechnologies.drivers.DriverManager.getDriver;

public class BaseTest {

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    protected AuthenticationWorkflow authenticationWorkflow;

    @BeforeMethod
    public void setUp(){

        logger.info("Test setup started.");

        DriverManager.setDriver(DriverFactory.initializeDriver());

        logger.info("Browser initialized successfully.");

        authenticationWorkflow = new AuthenticationWorkflow(getDriver());

        logger.info("AuthenticationWorkflow initialized successfully.");
    }


    @AfterMethod
    public void tearDown(){

        logger.info("Closing browser.");

        getDriver().quit();

        DriverManager.removeDriver();

        logger.info("Test teardown completed.");
    }
}
