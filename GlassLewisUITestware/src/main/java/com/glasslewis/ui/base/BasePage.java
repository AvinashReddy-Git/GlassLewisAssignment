package com.glasslewis.ui.base;

import static com.glasslewis.ui.constants.Constants.EXPLICT_WAIT;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final JavascriptExecutor jse;
    protected final WebDriverWait wait;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICT_WAIT,1));
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor) driver;

    }

    protected void waitForText(final WebElement element, final String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForVisibilityOfElement(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
