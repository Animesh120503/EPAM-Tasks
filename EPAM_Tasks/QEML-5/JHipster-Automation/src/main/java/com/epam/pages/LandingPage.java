package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private final By signInLink = By.xpath("//a[@class='alert-link' and text()='sign in']");
    private final By registerLink = By.xpath("//a[@routerLink='/account/register' and text()='Register a new account']");

//    public LandingPage(WebDriver driver){
//        super(driver);
//    }

    public void clickOnSignInLink(){
        click(signInLink);
    }

    public void clickOnRegistrationLink(){
        click(registerLink);
    }
}
