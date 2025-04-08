//package com.epam.pages;
//
//import com.epam.base.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//
//public class BankAccountPage extends BasePage {
//
//    private final By createNewBankAccountBtn = By.id("jh-create-entity");
//    private final By nameField = By.id("field_name");
//    private final By balanceField = By.id("field_balance");
//    private final By userField = By.id("field_user");
//    private final By cancelBtn = By.id("cancel-save");
//    private final By saveBtn = By.id("");
//    private final By bankAccountTableEntity = By.xpath("//div[@id='entities']/table/tbody/tr");
//
//    private final By footerElement = By.xpath("//p[@jhitranslate='footer']");
//
//    static int count;
//
//    public void clickOnCreateNewBankAccount(){
////        count();
//        click(createNewBankAccountBtn);
//    }
//
//    public void setName(String name){
//        sendKeys(nameField, name);
//    }
//
//    public void setBalance(String balance){
//        sendKeys(balanceField, balance);
//    }
//
//    public void setUser(String value){
//        selectByVisibleText(userField, value);
//    }
//
//    public void clickOnSave(){
//        click(saveBtn);
//    }
//
//    public void clickOnCancel(){
//        click(cancelBtn);
//    }
//
////    public boolean isNewBankAccountCreated(){
////        scrollToElement(footerElement);
////
////    }
//}
