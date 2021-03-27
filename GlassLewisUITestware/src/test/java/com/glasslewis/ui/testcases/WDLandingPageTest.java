package com.glasslewis.ui.testcases;

import static com.glasslewis.ui.constants.Constants.SERVER_URL;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.glasslewis.ui.base.TestBase;
import com.glasslewis.ui.pages.WDLandingPage;

public class WDLandingPageTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(WDLandingPageTest.class);
    private WDLandingPage landingPage;

    @BeforeMethod
    @Parameters("BrowserType")
    public void setUp(final String browserType) {
        logger.debug("In setUp method");
        initialization(SERVER_URL, browserType);
        landingPage =new WDLandingPage(getDriver());

    }

    @Test(description = "Verify country filter functionality")
    public void countryFilterTest() throws InterruptedException {

        landingPage.applyCountryFilter();
        Thread.sleep(3000);
        List<Map<String,String>> content =landingPage.getGridContent();
        for(Map<String,String> row: content) {
            String countryName=row.get("Country").trim();
            Assert.assertEquals("Belgium",countryName, "Other country is present");
        }
    }

    @AfterMethod
    public void tearDown() {
        cleanUp();
    }

}
