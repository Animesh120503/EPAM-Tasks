package com.epam.ui.base;

import com.epam.config.ConfigReader;
import com.epam.drivers.DriverManager;
import com.epam.pages.MainPage;
import com.epam.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class BaseTest {
    protected WebDriver driver;

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(@Optional("edge") String browserType) {
        DriverManager.setDriver(browserType);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    public void testValidLogin() {
        navigateToUrl("base_url");

        mainPage = new MainPage(driver)
                .clickOnSignInLink();

        loginPage = new LoginPage(driver)
                .sendUsername(ConfigReader.getProperty("valid_username"))
                .sendPassword(ConfigReader.getProperty("valid_password"))
                .clickLoginButton();

        assertTrue(mainPage.getSuccessMessage().contains("You are logged in as user"));
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public void navigateToUrl(String url) {
        driver.get(Objects.requireNonNull(ConfigReader.getProperty(url)));
    }
}
