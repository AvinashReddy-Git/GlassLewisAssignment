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

    @Override
    public void onTestFailure(final ITestResult result) {
        try {
            Object currentClass = result.getInstance();
            WebDriver driver = ((TestBase) currentClass).getDriver();
            TestUtil.takeScreenshot(driver, result.getMethod().getMethodName());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void onFinish(final ITestContext context) {
    }

    public void onTestStart(final ITestResult result) {
    }

    public void onTestSuccess(final ITestResult result) {
    }

    public void onTestSkipped(final ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    public void onStart(final ITestContext context) {
    }
}