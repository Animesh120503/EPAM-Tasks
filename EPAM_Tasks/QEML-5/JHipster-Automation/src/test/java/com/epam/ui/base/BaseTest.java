package com.epam.ui.base;

import com.epam.ui.config.UIConfigReader;
import com.epam.ui.drivers.DriverManager;
import com.epam.ui.pages.MainPage;
import com.epam.ui.pages.LoginPage;
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
                .sendUsername(UIConfigReader.getProperty("valid_username"))
                .sendPassword(UIConfigReader.getProperty("valid_password"))
                .clickLoginButton();

        assertTrue(mainPage.getSuccessMessage().contains("You are logged in as user"));
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public void navigateToUrl(String url) {
        driver.get(Objects.requireNonNull(UIConfigReader.getProperty(url)));
    }
}
