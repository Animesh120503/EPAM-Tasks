package com.epam.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private DriverManager(){}

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browserType){
        DriverFactory driverFactory = new DriverFactory();
        driver.set(driverFactory.initializeDriver(browserType));
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
        }
    }
}
