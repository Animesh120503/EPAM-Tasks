package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By signInBtn = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//div[@jhitranslate='login.messages.error.authentication']");

    public void sendUsername(String usernameStr){
        sendKeys(username, usernameStr);
    }

    public void sendPassword(String passwordStr){
        sendKeys(password, passwordStr);
    }

    public void clickLoginButton(){
        click(signInBtn);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
