package com.epam.ui.tests.bankAccount;

import com.epam.ui.base.BaseTest;
import com.epam.pages.BankAccountPage;
import com.epam.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateBankAccountTest extends BaseTest {

    MainPage mainPage;
    BankAccountPage bankAccountPage;

    @BeforeClass
    public void openUrlAndInitializePages() {
        testValidLogin();
    }

    @Test
    public void testCreateNewBankAccount() {
        String name = "New User";
        String balance = "25000";
        String user = "user";

        mainPage = new MainPage(driver)
                .selectEntityMenu()
                .selectBankAccountOption();

        bankAccountPage = new BankAccountPage(driver)
                .clickOnCreateNewBankAccount()
                .setName(name)
                .setBalance(balance)
                .setUser(user)
                .clickOnSave();

        assertTrue(bankAccountPage.isNewBankAccountCreated(name, balance, user));
    }
}
