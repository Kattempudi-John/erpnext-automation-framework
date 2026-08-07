package com.erpTechnologies.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final By searchButton =
            By.xpath("//button[@title='Search']");

    private final By searchInput =
            By.xpath("//input[@id='navbar-search']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickSearch(){
        click(searchButton,"Search button");
    }

    public void enterSearchText(String text){
        type(searchInput, text, "Search Input");
    }

    public void pressEnter(){
        pressEnter(searchInput, "Search Enter");
    }


    public CustomerPage openCustomerPage(){
        clickSearch();
        enterSearchText("Customer");
        pressEnter();

        return new CustomerPage(getDriver());
    }
}
