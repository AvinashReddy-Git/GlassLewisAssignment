package com.glasslewis.ui.base;

import static com.glasslewis.ui.constants.Constants.EXPLICT_WAIT;
import static com.glasslewis.ui.constants.Constants.IMPLICIT_WAIT;
import static com.glasslewis.ui.constants.Constants.PAGE_LOAD_TIMEOUT;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glasslewis.ui.util.Browser;
import com.glasslewis.ui.util.WebEventListener;

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private WebDriver driver;
    private WebDriverWait wait;


    public TestBase() {

    }

    public TestBase(WebDriver driver) {
        setDriver(driver);
        initPage();
    }

    protected void initialization(final String url, final String browserType) {
        Browser browser = Browser.getBrowser(browserType);
        WebDriver basicDriver = browser.getDriver();
        basicDriver.manage().window().maximize();
        basicDriver.manage().deleteAllCookies();
        basicDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        basicDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        logger.debug("Launching {}", url);
        basicDriver.get(url);
        WebEventListener eventListener = new WebEventListener();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(basicDriver);
        eventDriver.register(eventListener);
        setDriver(eventDriver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void initPage() {
        PageFactory.initElements(driver, this);
    }

    public void cleanUp() {
        logger.debug("In cleanUp  method,Quitting driver");
        getDriver().quit();
    }

    public WebDriverWait getExplicitWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), EXPLICT_WAIT);
        }
        return wait;
    }

    public void waitForUrl(String url) {
        getExplicitWait().until(ExpectedConditions.urlContains(url));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        getExplicitWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForText(WebElement element, String text) {
        getExplicitWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForUrlToContain(String url) {
        getExplicitWait().until(ExpectedConditions.urlContains(url));
    }

}