package com.glasslewis.ui.util;

import java.util.Collections;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glasslewis.ui.constants.Constants;

public enum Browser {
    CHROME {
        @Override
        public WebDriver getDriver() {

            logger.info("Initializing Chrome browser..");

            System.setProperty("webdriver.chrome.silentOutput", "true");
            java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
            System.setProperty("webdriver.chrome.logfile", Constants.CHROME_LOGFILE);

            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

            if (Boolean.valueOf(System.getProperty("headless", "false"))) {
                logger.info("Setting to headless true");
                chromeOptions.addArguments("--headless");
            }
            WebDriver driver = new ChromeDriver(chromeOptions);
            logger.info("Initialized Chrome browser successfully");
            return driver;
        }
    },
    EDGE {
        @Override
        public WebDriver getDriver() {
            logger.info("Initializing EDGE browser..");
            System.setProperty("webdriver.edge.driver", Constants.EDGE_DRIVER);
            EdgeOptions options = new EdgeOptions();
            if (Boolean.valueOf(System.getProperty("headless", "false"))) {
                logger.info("Setting to headless true");
                options.addArguments("headless");
            }
            WebDriver driver = new EdgeDriver(options);
            logger.info("Initialized EDGE browser successfully");
            return driver;
        }
    },
    FIREFOX {
        @Override
        public WebDriver getDriver() {
            logger.info("Initializing FireFox browser..");
            System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER);
            java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, Constants.FIREFOX_LOGFILE);

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 1);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;text/xml;application/xml");
            profile.setPreference("pdfjs.disabled", true);
            firefoxOptions.setProfile(profile);

            if (Boolean.valueOf(System.getProperty("headless", "false"))) {
                logger.info("Setting to headless true");
                firefoxOptions.setHeadless(true);
            }

            WebDriver driver = new FirefoxDriver(firefoxOptions);
            logger.info("Initialized FireFox browser successfully");
            return driver;
        }

    };

    private static final Logger logger = LoggerFactory.getLogger(Browser.class);

    public static Browser getBrowser(String browserName) {
        try {
            return Browser.valueOf(browserName);
        } catch (IllegalArgumentException exception) {
            logger.error("{} not supported", browserName);
            logger.info("Executing with default Chrome Browser");
            return CHROME;
        }
    }

    public abstract WebDriver getDriver();
}