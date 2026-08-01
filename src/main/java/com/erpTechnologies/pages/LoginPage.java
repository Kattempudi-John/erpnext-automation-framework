package com.erpTechnologies.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    private final By usernameInput = By.id("login_email");

    private final By passwordInput = By.id("login_password");

    private final By loginButton = By.xpath("//button[text()='Login']");

    private final By loginErrorMessage = By.cssSelector(".alert");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        type(usernameInput,username, "Username Input");
    }

    public void enterPassword(String password){
        type(passwordInput, password, "Password Input");
    }

    public void clickLogin(){
        click(loginButton, "Login Button");
    }

    public String getLoginErrorMessage(){
        return getText(
                loginErrorMessage,
                "Login Error Message");
    }

    public DashboardPage login(String username, String password){

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        return new DashboardPage(getDriver());
    }






}
