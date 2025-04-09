package com.epam.ui.pages;

import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    private final By username = By.xpath("//input[@data-cy='username']");
    private final By email = By.id("email");
    private final By newPassword = By.id("password");
    private final By confirmPassword = By.id("confirmPassword");
    private final By registerBtn = By.xpath("//button[@type='submit']");
    private final By registrationSuccessMessage = By.xpath("//div[@jhitranslate='register.messages.success']");

    public RegisterPage enterUsername(String usernameStr){
        sendKeys(username, usernameStr);
        return  this;
    }

    public RegisterPage enterEmail(String emailStr){
        sendKeys(email, emailStr);
        return this;
    }

    public RegisterPage enterPassword(String passwordStr){
        sendKeys(newPassword, passwordStr);
        return this;
    }

    public RegisterPage enterConfirmPassword(String confirmPasswordStr){
        sendKeys(confirmPassword, confirmPasswordStr);
        return this;
    }

    public RegisterPage clickOnRegisterButton(){
        click(registerBtn);
        return this;
    }

    public String getRegistrationSuccessMessage(){
        return getText(registrationSuccessMessage);
    }
}
