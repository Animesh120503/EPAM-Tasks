package com.epam.base;

import com.epam.config.ConfigReader;
import com.epam.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Objects;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(@Optional("chrome") String browserType){
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
