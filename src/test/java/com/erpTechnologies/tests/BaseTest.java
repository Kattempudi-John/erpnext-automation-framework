package com.erpTechnologies.tests;

import com.erpTechnologies.drivers.DriverFactory;
import com.erpTechnologies.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.setDriver(DriverFactory.initializeDriver());
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.getDriver().quit();
        DriverManager.unloadDriver();
    }
}
