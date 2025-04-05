package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    private final By username = By.xpath("//input[@data-cy='username']");
    private final By email = By.id("email");
    private final By newPassword = By.id("password");
    private final By confirmPassword = By.id("confirmPassword");
    private final By registerBtn = By.xpath("//button[@type='submit' and text()='Register']");
    private final By registrationSuccessMessage = By.xpath("//div[@class='alert alert-success']");

//    public RegisterPage(WebDriver driver){
//        super(driver);
//    }

    public void enterUsername(String usernameStr){
        sendKeys(username, usernameStr);
    }

    public void enterEmail(String emailStr){
        sendKeys(email, emailStr);
    }

    public void enterPassword(String passwordStr){
        sendKeys(newPassword, passwordStr);
    }

    public void enterConfirmPassword(String confirmPasswordStr){
        sendKeys(confirmPassword, confirmPasswordStr);
    }

    public void clickOnRegisterButton(){
        click(registerBtn);
    }

    public String getRegistrationSuccessMessage(){
        return getText(registrationSuccessMessage);
    }
}
