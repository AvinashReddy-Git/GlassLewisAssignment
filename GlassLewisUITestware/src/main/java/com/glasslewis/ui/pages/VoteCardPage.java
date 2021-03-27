package com.glasslewis.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.glasslewis.ui.base.TestBase;

public class VoteCardPage extends TestBase {

    @FindBy(id = "detail-issuer-name")
    private WebElement companyBanner;

    public VoteCardPage(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        waitForText(this.companyBanner,"Activision Blizzard Inc");
        return this.companyBanner.getText();
    }

}
