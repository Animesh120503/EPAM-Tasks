package com.epam.tests.register;

import com.epam.base.BaseTest;
import com.epam.config.ConfigReader;
import com.epam.pages.LandingPage;
import com.epam.pages.RegisterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    LandingPage landingPage;

    @BeforeClass
    public void initializePagesAndNavigateToRegisterURL() {
        System.out.println("Before class of Register test! I have been called..."+Thread.currentThread().getId());
        navigateToUrl("base_url");

        landingPage = new LandingPage(driver);
        landingPage.clickOnRegistrationLink();
    }

    @Test
    public void testValidRegistration(){
        registerPage = new RegisterPage(driver);
        registerPage.enterUsername("Animesh");
        registerPage.enterEmail("user@localhost.com");
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");

        registerPage.clickOnRegisterButton();

        assertEquals(registerPage.getRegistrationSuccessMessage(),
                "Registration saved! Please check your email for confirmation.");
//        driver.get(Objects.requireNonNull(ConfigReader.getProperty("register_url")));
    }
}
