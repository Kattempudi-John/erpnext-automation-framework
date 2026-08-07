package com.erpTechnologies.workflows;

import com.erpTechnologies.pages.HomePage;
import com.erpTechnologies.pages.LoginPage;
import com.erpTechnologies.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;

public class AuthenticationWorkflow{

    private final WebDriver driver;

    public AuthenticationWorkflow(WebDriver driver){
        this.driver = driver;
    }

    public HomePage loginAsAdmin() {

        LoginPage loginPage = new LoginPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        HomePage homePage =
                loginPage.login(username,password);

        return homePage;
    }

}
