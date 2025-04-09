package com.epam.tests.bankAccount;

import com.epam.base.BaseTest;
import com.epam.pages.BankAccountPage;
import com.epam.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateBankAccountTest extends BaseTest {

    HomePage homePage;
    BankAccountPage bankAccountPage;

    @BeforeClass
    public void openUrlAndInitializePages(){
        testValidLogin();
    }

    @Test
    public void testCreateNewBankAccount(){
        String name = "New User";
        String balance = "25000";
        String user = "user";

        homePage = new HomePage(driver);
        homePage.selectEntityMenu();
        homePage.selectBankAccountOption();

        bankAccountPage = new BankAccountPage(driver);
        bankAccountPage.clickOnCreateNewBankAccount();
        bankAccountPage.setName(name);
        bankAccountPage.setBalance(balance);
        bankAccountPage.setUser(user);
        bankAccountPage.clickOnSave();

        assertTrue(bankAccountPage.isNewBankAccountCreated(name, balance, user));
    }
}
