package com.epam.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement waitForElementToBeLocated(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void sendKeys(By locator, String key){
        waitForElementToBeLocated(locator).sendKeys(key);
    }

    protected void click(By locator){
        waitForElementToBeClickable(locator).click();
    }

    protected String getText(By locator){
        return waitForElementToBeLocated(locator).getText();
    }

    protected void scrollToElement(By locator){
        new Actions(driver)
                .scrollToElement(driver.findElement(locator))
                .perform();
    }

    protected void selectByVisibleText(By locator, String value){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

}
