package com.epam.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GlobalListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(GlobalListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test execution started {} {}",
                result.getTestClass(),
                result.getStartMillis()+"ms");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test execution successful {} {}",
                result.getTestClass(),
                result.getEndMillis()-result.getStartMillis()+"ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test execution failed {} {} {}",
                result.getTestClass(),
                result.getEndMillis()-result.getStartMillis()+"ms",
                result.getStatus());
    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//    }
}
