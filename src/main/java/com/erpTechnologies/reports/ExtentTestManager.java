package com.erpTechnologies.reports;

import com.aventstack.extentreports.ExtentTest;
import com.erpTechnologies.drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static final Logger logger =
            LogManager.getLogger(ExtentTestManager.class);

    public static void setTest(ExtentTest extentTest){
        test.set(extentTest);
        logger.info("ExtentTest instance stored successfully.");
    }

    public static ExtentTest getTest(){
        logger.debug("Retrieving ExtentTest instance.");
        return test.get();
    }

    public static void unloadTest(){
        test.remove();
        logger.info("ExtentTest instance removed successfully.");
    }
}
