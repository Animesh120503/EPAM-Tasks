package com.epam.BDDFrameworks.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"com.epam.BDDFrameworks.steps.ui", "com.epam.BDDFrameworks.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/UIReport.html"}
)
public class UIRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}