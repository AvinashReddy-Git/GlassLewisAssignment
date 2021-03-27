package com.glasslewis.ui.testcases;

import static com.glasslewis.ui.constants.Constants.SERVER_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.glasslewis.ui.base.TestBase;
import com.glasslewis.ui.pages.VoteCardPage;
import com.glasslewis.ui.pages.WDLandingPage;

public class VoteCardPageTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(VoteCardPageTest.class);
    private WDLandingPage landingPage;
    private VoteCardPage voteCardPageTest;

    @BeforeMethod
    @Parameters("BrowserType")
    public void setUp(final String browserType) {
        logger.debug("In setUp method");
        initialization(SERVER_URL, browserType);
        landingPage =new WDLandingPage(getDriver());
        voteCardPageTest=new VoteCardPage(getDriver());
    }

    @Test
    public void test1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        landingPage.applyCountryFilter();

    }

    @AfterMethod
    public void tearDown() {
        cleanUp();
    }
}
