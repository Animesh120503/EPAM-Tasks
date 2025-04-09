package com.epam.ui.pages;

import com.epam.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankAccountPage extends BasePage {

    public BankAccountPage(WebDriver driver){
        super(driver);
    }

    private final By createNewBankAccountBtn = By.id("jh-create-entity");
    private final By nameField = By.id("field_name");
    private final By balanceField = By.id("field_balance");
    private final By userField = By.id("field_user");
    private final By cancelBtn = By.id("cancel-save");
    private final By saveBtn = By.id("save-entity");

    private final By footerElement = By.xpath("//p[@jhitranslate='footer']");

    public BankAccountPage clickOnCreateNewBankAccount(){
        click(createNewBankAccountBtn);
        return this;
    }

    public BankAccountPage setName(String name){
        sendKeys(nameField, name);
        return this;
    }

    public BankAccountPage setBalance(String balance){
        sendKeys(balanceField, balance);
        return this;
    }

    public BankAccountPage setUser(String value){
        selectByVisibleText(userField, value);
        return this;
    }

    public BankAccountPage clickOnSave(){
        click(saveBtn);
        return this;
    }

    public BankAccountPage clickOnCancel(){
        click(cancelBtn);
        return this;
    }

    public boolean isNewBankAccountCreated(String name, String balance, String user){
        scrollToElement(footerElement);

        By nameElement = By.xpath("//div[@id='entities']/table/tbody/tr[last()]/td[2]");
        By balanceElement = By.xpath("//div[@id='entities']/table/tbody/tr[last()]/td[3]");
        By userElement = By.xpath("//div[@id='entities']/table/tbody/tr[last()]/td[4]");

        return getText(nameElement).equalsIgnoreCase(name)
                && getText(balanceElement).equalsIgnoreCase(balance)
                && getText(userElement).equalsIgnoreCase(user);
    }
}
