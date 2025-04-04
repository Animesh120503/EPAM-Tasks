package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private final By accountMenu = By.id("account-menu");
    private final By logout = By.id("logout");
    private final By errorMessage = By.xpath("//div[@class='alert alert-danger']");

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectAccountMenu(){
        click(accountMenu);
    }

    public void signOut(){
        click(logout);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
