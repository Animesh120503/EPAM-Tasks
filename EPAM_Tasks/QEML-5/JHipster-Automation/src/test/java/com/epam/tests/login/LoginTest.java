package com.epam.tests.login;

import com.epam.dataproviders.DataProviderUtil;
import com.epam.base.BaseTest;
import com.epam.listeners.GlobalListener;
import com.epam.pages.HomePage;
import com.epam.pages.LandingPage;
import com.epam.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(GlobalListener.class)
public class LoginTest extends BaseTest {

    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void initializePages(){
        System.out.println("Before class of Login test! I have been called..."+Thread.currentThread().getId());
        navigateToUrl("base_url");

        landingPage = new LandingPage(driver);
        landingPage.clickOnSignInLink();
    }

    @Test(dataProvider = "getValidLoginData", dataProviderClass = DataProviderUtil.class)
    public void testLoginWithValidData(String username, String password){
        loginPage = new LoginPage(driver);
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginButton();

//        try {
//            homePage = new HomePage(driver);
//            assertTrue(homePage.getSuccessMessage().contains("You are logged in as user"));
//            homePage.selectAccountMenu();
//            homePage.clickOnSignOut();
//
//            landingPage.clickOnSignInLink();
//        } catch(TimeoutException e){
////            assertEquals(loginPage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
//            driver.navigate().refresh();
//        } catch(StaleElementReferenceException e){
//            System.out.println("A stale element has been caught not timeout!!!");
//        }
            homePage = new HomePage(driver);
            assertTrue(homePage.getSuccessMessage().contains("You are logged in as user"));
            homePage.selectAccountMenu();
            homePage.clickOnSignOut();

            landingPage.clickOnSignInLink();
    }

    @Test(dataProvider = "getInvalidLoginData", dataProviderClass = DataProviderUtil.class)
    public void testLoginWithInvalidData(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginButton();

        assertEquals(loginPage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
        driver.navigate().refresh();
    }
}
