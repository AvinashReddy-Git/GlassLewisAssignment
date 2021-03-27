package com.glasslewis.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebEventListener implements WebDriverEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebEventListener.class);

    @Override
    public void beforeAlertAccept(final WebDriver driver) {
        logger.debug("Before accepting the alert");

    }

    @Override
    public void afterAlertAccept(final WebDriver driver) {
        logger.debug("After accepting the alert");
    }

    @Override
    public void afterAlertDismiss(final WebDriver driver) {
        logger.debug("After alert dismissed");

    }

    @Override
    public void beforeAlertDismiss(final WebDriver driver) {
        logger.debug("Before dismissing the alert");

    }

    @Override
    public void beforeNavigateTo(final String url, final WebDriver driver) {
        logger.debug("Before navigating to: {}", url);

    }

    @Override
    public void afterNavigateTo(final String url, final WebDriver driver) {
        logger.debug("After navigated to: {}", url);

    }

    @Override
    public void beforeNavigateBack(final WebDriver driver) {
        logger.debug("Navigating back to previous page {}", driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(final WebDriver driver) {
        logger.debug("Navigated back to previous page {}", driver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateForward(final WebDriver driver) {
        logger.debug("Navigating forward to next page {}", driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(final WebDriver driver) {
        logger.debug("Navigated forward to next page {}", driver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateRefresh(final WebDriver driver) {
        logger.debug("Navigating to refresh  page {}", driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateRefresh(final WebDriver driver) {
        logger.debug("Navigated to  refresh page {}", driver.getCurrentUrl());

    }

    @Override
    public void beforeFindBy(final By by, final WebElement element, final WebDriver driver) {
        logger.debug("Trying to find Element By : {}", by);

    }

    @Override
    public void afterFindBy(final By by, final WebElement element, final WebDriver driver) {
        logger.debug("Found Element By : {}", by);

    }

    @Override
    public void beforeClickOn(final WebElement element, final WebDriver driver) {
        logger.debug("Trying to click on: {}", element);
    }

    @Override
    public void afterClickOn(final WebElement element, final WebDriver driver) {
        logger.debug("Clicked on: {}", element);
    }

    @Override
    public void beforeChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
        logger.debug("Value of the: {} before any changes made", element);

    }

    @Override
    public void afterChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
        logger.debug("Element value changed to: {}", element);

    }

    @Override
    public void beforeScript(final String script, final WebDriver driver) {
        logger.debug("Before {} script executing", script);
    }

    @Override
    public void afterScript(final String script, final WebDriver driver) {
        logger.debug("After executing {} script ", script);
    }

    @Override
    public void beforeSwitchToWindow(final String windowName, final WebDriver driver) {
        logger.debug("Before switching to window {}  ", windowName);
    }

    @Override
    public void afterSwitchToWindow(final String windowName, final WebDriver driver) {
        logger.debug("After switching to window {}  ", windowName);
    }

    @Override
    public void onException(final Throwable throwable, final WebDriver driver) {
        logger.debug("Exception occured: {}", throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(final OutputType<X> target) {
        logger.debug("Called before TakesScreenshot.getScreenshotAs(OutputType)");

    }

    @Override
    public <X> void afterGetScreenshotAs(final OutputType<X> target, final X screenshot) {
        logger.debug("Called after TakesScreenshot.getScreenshotAs(OutputType)");
    }

    @Override
    public void beforeGetText(final WebElement element, final WebDriver driver) {
        logger.debug("Before getting the text for {}", element);

    }

    @Override
    public void afterGetText(final WebElement element, final WebDriver driver, final String text) {
        logger.debug("Text of {} is {}", element, text);

    }
}