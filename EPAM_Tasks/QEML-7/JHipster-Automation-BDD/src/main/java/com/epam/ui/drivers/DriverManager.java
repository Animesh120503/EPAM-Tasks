package com.epam.ui.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void setDriver(String browserType){
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
