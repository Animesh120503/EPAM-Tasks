package com.epam.BDDFrameworks.steps.ui;

import com.epam.ui.config.UIConfigReader;
import com.epam.ui.drivers.DriverManager;
import com.epam.ui.pages.MainPage;
import com.epam.ui.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps {
    WebDriver driver = DriverManager.getDriver();

    MainPage mainPage;
    RegisterPage registerPage;

    @Given("I am on registration page")
    public void iAmOnRegistrationPage() {
        String baseUrl = Objects.requireNonNull(UIConfigReader.getProperty("base_url"));
        driver.get(baseUrl);

        mainPage = new MainPage(driver)
                .clickOnRegistrationLink();
    }

    @When("I enter valid {string} and {string} and {string} and {string}")
    public void iEnterValidAndAndAnd(String username, String email, String password, String confirmPassword) {
        registerPage = new RegisterPage(driver)
                .enterUsername(username)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword);
    }

    @And("click register button")
    public void clickRegisterButton() {
        registerPage = new RegisterPage(driver)
                .clickOnRegisterButton();
    }

    @Then("I should be see a success message")
    public void iShouldBeSeeASuccessMessage() {
        assertEquals(registerPage.getRegistrationSuccessMessage(),
                "Registration saved! Please check your email for confirmation.");
    }
}
