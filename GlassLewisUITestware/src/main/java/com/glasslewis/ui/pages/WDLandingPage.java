package com.glasslewis.ui.pages;

import org.openqa.selenium.By;
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

   @FindBy(xpath="//div[@id='grid']")
   private WebElement tableGrid;


 /*   By belgiumCheckBox = By.xpath("//div[@id='filter-country']//label[@id='Belgium-cb-label-CountryFilter']");

    By countryUpdateButton=By.xpath("//body/div[@id='wd-site-page']/div[2]/aside[1]/div[4]/div[1]/div[2]/div[2]/button[1]");*/

    //  By  companyActivisionBlizzardIncLink =By.xpath("//a[contains(text(),'Activision Blizzard Inc')]");

    public WDLandingPage(WebDriver driver) {
        super(driver);
    }

    public void applyCountryFilter() {

        this.belgiumCheckBox.click();
        this.countryUpdateButton.click();

    }

 public void getGridContent() throws InterruptedException {
     TableUtil.getGridTableContent(tableGrid);
 }
    public void getGridHeader() throws InterruptedException {
        TableUtil.getGridTableContent(tableGrid);
    }
}
