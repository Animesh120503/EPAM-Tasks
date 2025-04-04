package com.epam.base;

import com.epam.config.ConfigReader;
import com.epam.drivers.DriverFactory;
import com.epam.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(String browserType){
        DriverManager.setDriver(browserType);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        DriverManager.quitDriver();
    }

    public void navigateToUrl(String url){
        driver.get(Objects.requireNonNull(ConfigReader.getProperty(url)));
    }
}
