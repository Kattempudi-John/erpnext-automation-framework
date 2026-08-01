package com.erpTechnologies.pages;

import com.erpTechnologies.components.HeaderComponent;
import com.erpTechnologies.components.SidebarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final HeaderComponent header;

    private final SidebarComponent sidebar;

    private final By dashboardHeader =
            By.xpath("//h[text()='Dashboard']");


    public DashboardPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.sidebar = new SidebarComponent(driver);
    }

    public HeaderComponent getHeader(){
        return header;
    }

    public SidebarComponent getSidebar(){
        return sidebar;
    }
    public boolean isDashboardLoaded(){

        return isDisplayed(
                dashboardHeader,
                "Dashboard Header"
        );
    }





}
