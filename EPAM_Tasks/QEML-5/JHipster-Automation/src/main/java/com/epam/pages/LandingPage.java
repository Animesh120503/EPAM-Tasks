package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver){
        super(driver);
    }

    private final By signInLink = By.xpath("//a[@jhitranslate='global.messages.info.authenticated.link']");
    private final By registerLink = By.xpath("//a[@jhitranslate='global.messages.info.register.link']");

    public void clickOnSignInLink(){
        click(signInLink);
    }

    public void clickOnRegistrationLink(){
        click(registerLink);
    }
}
