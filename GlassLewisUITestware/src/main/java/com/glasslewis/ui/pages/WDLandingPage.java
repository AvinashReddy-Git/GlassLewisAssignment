package com.glasslewis.ui.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.glasslewis.ui.base.BasePage;
import com.glasslewis.ui.util.TableUtil;

public class WDLandingPage extends BasePage {

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

    private static String CLICK = "arguments[0].click()";

    public WDLandingPage(final WebDriver driver) {
        super(driver);

    }

    public void applyCountryFilter() {

        jse.executeScript(CLICK, this.belgiumCheckBox);
        jse.executeScript(CLICK, this.countryUpdateButton);

    }

    public List<Map<String, String>> getGridContent() {
        waitForVisibilityOfElement(driver.findElement(By.xpath("//td[contains(text(),'Belgium')]")));
        return TableUtil.getGridTableContent(tableGrid);
    }

    public VoteCardPage navigateToVoteCardPage() {

        jse.executeScript(CLICK, this.usaCheckBox);
        jse.executeScript(CLICK, this.countryUpdateButton);

        this.companyActivisionBlizzardIncLink.click();
        return new VoteCardPage(driver);
    }

}
