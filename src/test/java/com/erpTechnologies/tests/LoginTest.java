package com.erpTechnologies.tests;

import com.erpTechnologies.drivers.DriverManager;
import com.erpTechnologies.listeners.TestListener;
import com.erpTechnologies.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test
    public void verifyApplicationLaunch(){
        logger.info("Login test execution started.");

        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));

        logger.info("ERPNext application launched successfully.");

        logger.info("Login test execution completed.");

        Assert.assertTrue(false, "Intentional Failure");

    }
}
