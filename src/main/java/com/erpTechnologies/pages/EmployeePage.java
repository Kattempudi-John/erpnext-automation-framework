package com.erpTechnologies.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePage {

    private final By employeePageHeader =
            By.xpath("//h[text()='Employee']");

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmployeePageLoaded(){

        return isDisplayed(employeePageHeader,"Employee Page");
    }
}
