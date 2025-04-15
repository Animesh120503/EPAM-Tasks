package com.epam.BDDFrameworks.steps.ui;

import com.epam.BDDFrameworks.hooks.UIHooks;
import com.epam.ui.config.UIConfigReader;
import com.epam.ui.drivers.DriverManager;
import com.epam.ui.pages.BankAccountPage;
import com.epam.ui.pages.LoginPage;
import com.epam.ui.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class CreateBankAccountSteps {
    WebDriver driver = DriverManager.getDriver();

    MainPage mainPage;
    LoginPage loginPage;
    BankAccountPage bankAccountPage;

    @Given("User is logged in")
    public void userIsLoggedIn() {
        String baseUrl = Objects.requireNonNull(UIConfigReader.getProperty("base_url"));
        driver.get(baseUrl);

        mainPage = new MainPage(driver)
                .clickOnSignInLink();

        loginPage = new LoginPage(driver)
                .sendUsername(UIConfigReader.getProperty("valid_username_user"))
                .sendPassword(UIConfigReader.getProperty("valid_password_user"))
                .clickLoginButton();
    }

    @And("User is on the bank accounts page")
    public void userIsOnTheBankAccountsPage() {
        mainPage = new MainPage(driver)
                .selectEntityMenu()
                .selectBankAccountOption();
    }

    @When("User clicks on create new bank account button")
    public void userClicksOnCreateNewBankAccountButton() {
        bankAccountPage = new BankAccountPage(driver)
                .clickOnCreateNewBankAccount();
    }

    @And("User enters valid {string} and {string} and {string}")
    public void userEntersValidAndAnd(String name, String balance, String user) {
        bankAccountPage = new BankAccountPage(driver)
                .setName(name)
                .setBalance(balance)
                .setUser(user)
                .clickOnSave();
    }

    @Then("a new bank account with {string} and {string} and {string} is created")
    public void aNewBankAccountWithAndAndIsCreated(String name, String balance, String user) {
        assertTrue(bankAccountPage.isNewBankAccountCreated(name, balance, user));
    }
}
