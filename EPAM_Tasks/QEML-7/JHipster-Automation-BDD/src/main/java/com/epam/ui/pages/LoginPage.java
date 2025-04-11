package com.epam.ui.pages;

import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By signInBtn = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//div[@jhitranslate='login.messages.error.authentication']");

    public LoginPage sendUsername(String usernameStr){
        sendKeys(username, usernameStr);
        return this;
    }

    public LoginPage sendPassword(String passwordStr){
        sendKeys(password, passwordStr);
        return this;
    }

    public LoginPage clickLoginButton(){
        click(signInBtn);
        return this;
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
