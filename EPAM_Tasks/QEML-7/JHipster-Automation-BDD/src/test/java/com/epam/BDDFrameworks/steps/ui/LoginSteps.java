package com.epam.BDDFrameworks.steps.ui;

import com.epam.ui.config.UIConfigReader;
import com.epam.ui.drivers.DriverManager;
import com.epam.ui.pages.LoginPage;
import com.epam.ui.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getDriver();
    MainPage mainPage;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        String baseUrl = Objects.requireNonNull(UIConfigReader.getProperty("base_url"));
        driver.get(baseUrl);

        mainPage = new MainPage(driver)
                .clickOnSignInLink();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPage = new LoginPage(driver)
                .sendUsername(UIConfigReader.getProperty("valid_username_user"))
                .sendPassword(UIConfigReader.getProperty("valid_password_user"))
                .clickLoginButton();
    }

    @When("I log in with valid admin credentials")
    public void iLogInWithValidAdminCredentials() {
        loginPage = new LoginPage(driver)
                .sendUsername(UIConfigReader.getProperty("valid_username_admin"))
                .sendPassword(UIConfigReader.getProperty("valid_password_admin"))
                .clickLoginButton();
    }

    @Then("I should see a user success message in main page")
    public void iShouldSeeAUserSuccessMessageInMainPage() {
        assertEquals(mainPage.getSuccessMessage(), "You are logged in as user \"user\".");
    }

    @Then("I should see a admin success message in main page")
    public void iShouldSeeAAdminSuccessMessageInMainPage() {
        assertEquals(mainPage.getSuccessMessage(), "You are logged in as user \"admin\".");
    }

    @When("I log in with invalid {string} and {string}")
    public void iLogInWithInvalidUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver)
                .sendUsername(username)
                .sendPassword(password)
                .clickLoginButton();
    }

    @Then("I should see an error message in the login page")
    public void iShouldSeeAnErrorMessageInTheLoginPage() {
        assertEquals(loginPage.getErrorMessage(), "Failed to sign in! Please check your credentials and try again.");
    }

}
