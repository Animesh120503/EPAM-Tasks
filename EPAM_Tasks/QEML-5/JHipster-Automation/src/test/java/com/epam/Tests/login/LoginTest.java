package com.epam.Tests.login;

import com.epam.dataproviders.DataProviderUtil;
import com.epam.base.BaseTest;
import com.epam.pages.HomePage;
import com.epam.pages.LoginPage;
import com.epam.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void initializeLoginPage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void getDriverUrl(){
        driver.get(Objects.requireNonNull(ConfigReader.getProperty("base_uri"))+ConfigReader.getProperty("login"));
    }

    @Test(dataProvider = "getExcelData", dataProviderClass = DataProviderUtil.class)
    public void testLogin(String username, String password){
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home-logged-message")));

            assertTrue(successMessage.getText().contains("You are logged in as user"));
            //Navigate back to sign in page
            homePage.selectAccountMenu();
            homePage.signOut();
        } catch(TimeoutException e){
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
            assertEquals(errorMessage.getText(), "Failed to sign in! Please check your credentials and try again.");
            driver.navigate().refresh();
        }
    }
}
