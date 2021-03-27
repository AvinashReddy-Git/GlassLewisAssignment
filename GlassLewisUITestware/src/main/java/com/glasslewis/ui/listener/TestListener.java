package com.glasslewis.ui.listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.glasslewis.ui.base.TestBase;
import com.glasslewis.ui.util.TestUtil;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);
    WebDriver driver = null;

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Object currentClass = result.getInstance();
            WebDriver driver = ((TestBase) currentClass).getDriver();
            TestUtil.takeScreenshot(driver, result.getMethod().getMethodName());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void onFinish(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }
}