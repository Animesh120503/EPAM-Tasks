package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private final By accountMenu = By.id("account-menu");
    private final By logout = By.id("logout");
    private final By entityMenu = By.id("entity-menu");
    private final By bankAccountOption = By.xpath("//span[@jhitranslate='global.menu.entities.bankAccount']");
    private final By successMessage = By.id("home-logged-message");

    public String getSuccessMessage(){
        return getText(successMessage);
    }

    public void selectAccountMenu(){
        click(accountMenu);
    }

    public void clickOnSignOut(){
        click(logout);
    }

    public void selectEntityMenu(){
        click(entityMenu);
    }

    public void selectBankAccountOption(){
        click(bankAccountOption);
    }
}
