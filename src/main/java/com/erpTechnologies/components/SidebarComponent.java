package com.erpTechnologies.components;

import com.erpTechnologies.pages.BasePage;
import com.erpTechnologies.pages.EmployeePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarComponent extends BasePage {

    private final By employeeMenu =
            By.id("Employee");

    public SidebarComponent(WebDriver driver){
        super(driver);
    }

    public EmployeePage clickEmployee(){
        click(employeeMenu, "Employee Menu");
        return new EmployeePage(getDriver());
    }



}
