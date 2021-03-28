package com.glasslewis.ui.base;

import static com.glasslewis.ui.constants.Constants.IMPLICIT_WAIT;
import static com.glasslewis.ui.constants.Constants.PAGE_LOAD_TIMEOUT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glasslewis.ui.util.Browser;
import com.glasslewis.ui.util.WebEventListener;

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private WebDriver driver;

    protected void initialization(final String url, final String browserType) {
        final Browser browser = Browser.getBrowser(browserType);
        final WebDriver basicDriver = browser.getDriver();
        basicDriver.manage().window().maximize();
        basicDriver.manage().deleteAllCookies();
        basicDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        basicDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        logger.debug("Launching {}", url);
        basicDriver.get(url);
        final WebEventListener eventListener = new WebEventListener();
        final EventFiringWebDriver eventDriver = new EventFiringWebDriver(basicDriver);
        eventDriver.register(eventListener);
        setDriver(eventDriver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(final WebDriver driver) {
        this.driver = driver;
    }

    public void cleanUp() {
        logger.info("In cleanUp  method,Quitting driver");
        driver.quit();
    }

}