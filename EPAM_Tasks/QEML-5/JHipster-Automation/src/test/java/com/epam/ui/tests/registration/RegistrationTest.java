package com.epam.ui.tests.registration;

import com.epam.ui.base.BaseTest;
import com.epam.pages.MainPage;
import com.epam.pages.RegisterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    RegisterPage registerPage;
    MainPage mainPage;

    @BeforeClass
    public void initializePagesAndNavigateToRegisterURL() {
        navigateToUrl("base_url");

        mainPage = new MainPage(driver)
                .clickOnRegistrationLink();
    }

    @Test
    public void testValidRegistration() {
        registerPage = new RegisterPage(driver)
                .enterUsername("Animesh")
                .enterEmail("user@localhost.com")
                .enterPassword("123456")
                .enterConfirmPassword("123456")
                .clickOnRegisterButton();

        assertEquals(registerPage.getRegistrationSuccessMessage(),
                "Registration saved! Please check your email for confirmation.");
    }
}
