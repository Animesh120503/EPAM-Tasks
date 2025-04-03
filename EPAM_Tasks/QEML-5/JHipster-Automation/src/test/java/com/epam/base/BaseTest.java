package com.epam.base;

import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    private final DriverFactory webDriver = new DriverFactory();

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(String browserType){
        driver = webDriver.initializeDriver(browserType);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
