package com.erpTechnologies.components;

import com.erpTechnologies.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    private final By profileIcon =
            By.id("Profile-Icon");

    private final By logoutButton =
            By.xpath("//button[text()='Logout']");

    public HeaderComponent(WebDriver driver){
        super(driver);
    }

    public void clickProfileIcon(){
        click(profileIcon, "User Profile Icon");
    }

    public void clickLogout(){
        click(logoutButton, "Logout button");
    }

    public void logout(){

        clickProfileIcon();

        clickLogout();
    }
}
