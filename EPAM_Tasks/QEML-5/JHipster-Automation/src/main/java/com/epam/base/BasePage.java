package com.epam.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement waitForElementToBeLocated(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void sendKeys(By locator, String key){
        waitForElementToBeLocated(locator).sendKeys(key);
    }

    protected void click(By locator){
        waitForElementToBeLocated(locator).click();
    }

    protected String getText(By locator){
        return waitForElementToBeLocated(locator).getText();
    }
}
