package com.glasslewis.ui.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.glasslewis.ui.base.TestBase;
import com.glasslewis.ui.util.TableUtil;

public class WDLandingPage extends TestBase {

    @FindBy(xpath = "//div[@id='filter-country']//label[@id='Belgium-cb-label-CountryFilter']")
    private WebElement belgiumCheckBox;

    @FindBy(xpath = "//div[@id='filter-country']//label[@id='UnitedStates-cb-label-CountryFilter']")
    private WebElement usaCheckBox;

    @FindBy(xpath = "//div[@id='filter-country']//button[@id='btn-update']")
    private WebElement countryUpdateButton;

    @FindBy(xpath = "//a[contains(text(),'Activision Blizzard Inc')]")
    private WebElement companyActivisionBlizzardIncLink;

    @FindBy(xpath = "//div[@id='grid']")
    private WebElement tableGrid;

    JavascriptExecutor jse = (JavascriptExecutor) getDriver();
    private static String CLICK="arguments[0].click()";

    public WDLandingPage(WebDriver driver) {
        super(driver);
    }

    public void applyCountryFilter() {

        jse.executeScript(CLICK, this.belgiumCheckBox);
        jse.executeScript(CLICK, this.countryUpdateButton);
    }

    public List<Map<String, String>> getGridContent() {
        return TableUtil.getGridTableContent(tableGrid);
    }

    public VoteCardPage navigateToVoteCardPage() {

        jse.executeScript(CLICK, this.usaCheckBox);
        jse.executeScript(CLICK, this.countryUpdateButton);

        this.companyActivisionBlizzardIncLink.click();
        return new VoteCardPage(getDriver());
    }

}
