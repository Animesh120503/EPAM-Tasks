package com.epam.pages;

import com.epam.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By accountMenu = By.id("account-menu");
    private final By logout = By.id("logout");
    private final By errorMessage = By.xpath("//div[@class='alert alert-danger']");

//    public HomePage(WebDriver driver){
//        super(driver);
//    }

    public void selectAccountMenu(){
        click(accountMenu);
    }

    public void clickOnSignOut(){
        click(logout);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}

//public class HomePage extends BasePage {
//
//    private By accountMenu;
//    private By logout;
//    private By errorMessage;
//
//    private HomePage(WebDriver driver, HomePageBuilder builder) {
//        super(driver);
//        this.accountMenu = builder.accountMenu;
//        this.logout = builder.logout;
//        this.errorMessage = builder.errorMessage;
//    }
//
//    // Actions that interact with the HomePage
//    public void selectAccountMenu() {
//        click(accountMenu);
//    }
//
//    public void clickOnSignOut() {
//        click(logout);
//    }
//
//    public String getErrorMessage() {
//        return getText(errorMessage);
//    }
//
//    public static class HomePageBuilder {
//        private By accountMenu = By.id("account-menu");
//        private By logout = By.id("logout");
//        private By errorMessage = By.xpath("//div[@class='alert alert-danger']");
//        private WebDriver driver;
//
//        // Constructor for the builder
//        public HomePageBuilder(WebDriver driver) {
//            this.driver = driver;
//        }
//
//        // Methods to configure or override default locators (if needed)
//        public HomePageBuilder setAccountMenu(By accountMenu) {
//            this.accountMenu = accountMenu;
//            return this;
//        }
//
//        public HomePageBuilder setLogout(By logout) {
//            this.logout = logout;
//            return this;
//        }
//
//        public HomePageBuilder setErrorMessageLocator(By errorMessage) {
//            this.errorMessage = errorMessage;
//            return this;
//        }
//
//        // Build the HomePage instance
//        public HomePage build() {
//            return new HomePage(driver, this);
//        }
//    }
//}