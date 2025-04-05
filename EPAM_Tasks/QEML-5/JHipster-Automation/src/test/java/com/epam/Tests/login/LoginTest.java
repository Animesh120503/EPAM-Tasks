package com.epam.Tests.login;

import com.epam.dataproviders.DataProviderUtil;
import com.epam.base.BaseTest;
import com.epam.listeners.GlobalListener;
import com.epam.pages.HomePage;
import com.epam.pages.LandingPage;
import com.epam.pages.LoginPage;
import org.openqa.selenium.TimeoutException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(GlobalListener.class)
public class LoginTest extends BaseTest {

    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;

    public void initializePages(){
//        landingPage = new LandingPage(driver);
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);

        landingPage = new LandingPage();
        loginPage = new LoginPage();
        homePage = new HomePage();

        navigateToUrl("base_url");
        landingPage.clickOnSignInLink();
    }

    @Test(dataProvider = "getExcelData", dataProviderClass = DataProviderUtil.class)
    public void testLogin(String username, String password){
        initializePages();
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginButton();

        try {
            assertTrue(loginPage.getSuccessMessage().contains("You are logged in as user"));
            homePage.selectAccountMenu();
            homePage.clickOnSignOut();

            landingPage.clickOnSignInLink();
        } catch(TimeoutException e){
            assertEquals(homePage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
            driver.navigate().refresh();
        }
    }
}
