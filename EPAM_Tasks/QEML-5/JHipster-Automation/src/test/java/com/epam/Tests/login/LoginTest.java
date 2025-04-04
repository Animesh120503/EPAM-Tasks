package com.epam.Tests.login;

import com.epam.dataproviders.DataProviderUtil;
import com.epam.base.BaseTest;
import com.epam.listeners.GlobalListener;
import com.epam.pages.HomePage;
import com.epam.pages.LoginPage;
import org.openqa.selenium.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(GlobalListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void initializePages(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void getDriverUrl(){
        navigateToUrl("login_url");
    }

    @Test(dataProvider = "getExcelData", dataProviderClass = DataProviderUtil.class)
    public void testLogin(String username, String password){
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginButton();

        try {
            assertTrue(loginPage.getSuccessMessage().contains("You are logged in as user"));
            homePage.selectAccountMenu();
            homePage.signOut();
        } catch(TimeoutException e){
            assertEquals(homePage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
            driver.navigate().refresh();
        }
    }
}
