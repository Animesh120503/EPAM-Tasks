package com.epam.Tests.register;

import com.epam.base.BaseTest;
import com.epam.pages.LandingPage;
import com.epam.pages.RegisterPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    LandingPage landingPage;

    public void initializePagesAndNavigateToRegisterURL() {
//        landingPage = new LandingPage(driver);
//        registerPage = new RegisterPage(driver);
        landingPage = new LandingPage();
        registerPage = new RegisterPage();

        navigateToUrl("base_url");
        landingPage.clickOnRegistrationLink();
    }

    @Test
    public void testValidRegistration(){
        initializePagesAndNavigateToRegisterURL();
        registerPage.enterUsername("Animesh");
        registerPage.enterEmail("user@localhost.com");
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");

        registerPage.clickOnRegisterButton();

        assertEquals(registerPage.getRegistrationSuccessMessage(),
                "Registration saved! Please check your email for confirmation.");
    }
}
