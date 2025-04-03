package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id="username")
    private WebElement username;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendUsername(String usernameStr){
        username.sendKeys(usernameStr);
    }

    public void sendPassword(String passwordStr){
        password.sendKeys(passwordStr);
    }

    public void clickLoginButton(){
        signInBtn.click();
    }
}
