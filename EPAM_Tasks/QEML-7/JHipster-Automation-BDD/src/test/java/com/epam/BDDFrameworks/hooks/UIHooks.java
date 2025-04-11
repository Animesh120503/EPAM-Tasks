package com.epam.BDDFrameworks.hooks;

import com.epam.ui.drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class UIHooks {
    WebDriver driver;

    @Before
//    @Parameters({"browserType"})
    public void setupWebDriver(){
        DriverManager.setDriver("edge");
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDownWebDriver(){
        DriverManager.quitDriver();
    }
}
