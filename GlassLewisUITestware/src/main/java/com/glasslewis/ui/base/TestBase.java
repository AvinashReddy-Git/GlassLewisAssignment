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


    public TestBase() {

    }


}