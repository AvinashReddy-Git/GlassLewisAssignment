package com.glasslewis.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.glasslewis.ui.base.TestBase;

public class VoteCardPage extends TestBase {

    @FindBy(id="detail-issuer-name")
    WebElement companyBanner;

   // By companyBanner=By.id("detail-issuer-name");

    public VoteCardPage(WebDriver driver) {
        super(driver);
    }

}
