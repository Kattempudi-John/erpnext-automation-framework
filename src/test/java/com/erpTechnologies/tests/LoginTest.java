package com.erpTechnologies.tests;

import com.erpTechnologies.drivers.DriverManager;
import com.erpTechnologies.utilities.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void verifyApplicationLunch(){
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));
    }
}
