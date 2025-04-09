package com.epam.base;

import com.epam.config.ConfigReader;
import com.epam.drivers.DriverManager;
import com.epam.pages.HomePage;
import com.epam.pages.LandingPage;
import com.epam.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class BaseTest {
    protected WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    LandingPage landingPage;

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(@Optional("edge") String browserType){
        System.out.println("Browser Type: " +browserType);
        System.out.println("Before test of base test! I have been called..."+Thread.currentThread().getId());
        DriverManager.setDriver(browserType);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    public void testValidLogin(){
        System.out.println("Test has been called inside base Test....");
        navigateToUrl("base_url");

        landingPage = new LandingPage(driver);
        landingPage.clickOnSignInLink();

        loginPage = new LoginPage(driver);
        loginPage.sendUsername(ConfigReader.getProperty("valid_username"));
        loginPage.sendPassword(ConfigReader.getProperty("valid_password"));
        loginPage.clickLoginButton();

        homePage = new HomePage(driver);
        assertTrue(homePage.getSuccessMessage().contains("You are logged in as user"));
    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test of base test! I have been called..."+Thread.currentThread().getId());
        DriverManager.quitDriver();
    }

    public void navigateToUrl(String url){
        driver.get(Objects.requireNonNull(ConfigReader.getProperty(url)));
    }
}
