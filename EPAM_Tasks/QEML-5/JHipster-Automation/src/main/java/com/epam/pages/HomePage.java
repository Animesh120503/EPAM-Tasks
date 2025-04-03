package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id="account-menu")
    private WebElement accountMenu;
    @FindBy(id="logout")
    private WebElement logout;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectAccountMenu(){
        accountMenu.click();
    }

    public void signOut(){
        logout.click();
    }
}
