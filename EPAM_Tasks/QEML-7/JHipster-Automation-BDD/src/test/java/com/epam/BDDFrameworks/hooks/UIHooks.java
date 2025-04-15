package com.epam.BDDFrameworks.hooks;

import com.epam.ui.drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void tearDownWebDriver(Scenario scenario){
//        try {
//            String screenshotName = scenario.getName();
//            if (scenario.isFailed()) {
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "img/png", screenshotName);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        DriverManager.quitDriver();
    }
}
