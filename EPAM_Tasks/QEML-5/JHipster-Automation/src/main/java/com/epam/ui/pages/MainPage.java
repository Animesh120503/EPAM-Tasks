package com.epam.ui.pages;

import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        super(driver);
    }

    private final By accountMenu = By.id("account-menu");
    private final By logout = By.id("logout");
    private final By entityMenu = By.id("entity-menu");
    private final By bankAccountOption = By.xpath("//span[@jhitranslate='global.menu.entities.bankAccount']");
    private final By successMessage = By.id("home-logged-message");

    private final By signInLink = By.xpath("//a[@jhitranslate='global.messages.info.authenticated.link']");
    private final By registerLink = By.xpath("//a[@jhitranslate='global.messages.info.register.link']");

    public String getSuccessMessage(){
        return getText(successMessage);
    }

    public MainPage selectAccountMenu(){
        click(accountMenu);
        return this;
    }

    public MainPage clickOnSignOut(){
        click(logout);
        return this;
    }

    public MainPage selectEntityMenu(){
        click(entityMenu);
        return this;
    }

    public MainPage selectBankAccountOption(){
        click(bankAccountOption);
        return this;
    }

    public MainPage clickOnSignInLink(){
        click(signInLink);
        return this;
    }

    public MainPage clickOnRegistrationLink(){
        click(registerLink);
        return this;
    }
}
