package com.epam.ui.tests.login;

import com.epam.ui.dataproviders.DataProviderUtil;
import com.epam.ui.base.BaseTest;
import com.epam.ui.listeners.GlobalListener;
import com.epam.pages.MainPage;
import com.epam.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(GlobalListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass
    public void initializePages(){
        navigateToUrl("base_url");

        mainPage = new MainPage(driver)
                .clickOnSignInLink();
    }

    @Test(dataProvider = "getValidLoginData", dataProviderClass = DataProviderUtil.class)
    public void testLoginWithValidData(String username, String password){

        loginPage = new LoginPage(driver)
                .sendUsername(username)
                .sendPassword(password)
                .clickLoginButton();

        assertTrue(mainPage.getSuccessMessage().contains("You are logged in as user"));

        mainPage.selectAccountMenu()
                .clickOnSignOut()
                .clickOnSignInLink();
    }

    @Test(dataProvider = "getInvalidLoginData", dataProviderClass = DataProviderUtil.class)
    public void testLoginWithInvalidData(String username, String password) {

        loginPage = new LoginPage(driver)
                .sendUsername(username)
                .sendPassword(password)
                .clickLoginButton();

        assertEquals(loginPage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
        driver.navigate().refresh();
    }
}
