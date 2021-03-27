package com.glasslewis.ui.pages;

import java.util.List;
import java.util.Map;

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

    @FindBy(xpath = "//body/div[@id='wd-site-page']/div[2]/aside[1]/div[4]/div[1]/div[2]/div[2]/button[1]")
    private WebElement countryUpdateButton;

    @FindBy(xpath = "//a[contains(text(),'Activision Blizzard Inc')]")
    private WebElement companyActivisionBlizzardIncLink;

    @FindBy(xpath = "//div[@id='grid']")
    private WebElement tableGrid;

    public WDLandingPage(WebDriver driver) {
        super(driver);
    }

    public void applyCountryFilter() {

        this.belgiumCheckBox.click();
        this.countryUpdateButton.click();

    }

    public List<Map<String, String>> getGridContent() {
       return TableUtil.getGridTableContent(tableGrid);
    }

    public VoteCardPage navigateToVoteCardPage() {

        this.usaCheckBox.click();
        this.countryUpdateButton.click();
        this.companyActivisionBlizzardIncLink.click();
        return new VoteCardPage(getDriver());
    }

}
