package com.glasslewis.ui.testcases;

import static com.glasslewis.ui.constants.Constants.CHROME_DRIVER;
import static com.glasslewis.ui.constants.Constants.IMPLICIT_WAIT;
import static com.glasslewis.ui.constants.Constants.PAGE_LOAD_TIMEOUT;
import static com.glasslewis.ui.constants.Constants.SERVER_URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SampleClass {

    @FindBy(xpath = "//div[@id='filter-country']//label[@id='Belgium-cb-label-CountryFilter']")
    private WebElement belgiumCheckBox;

    @FindBy(xpath = "//div[@id='filter-country']//label[@id='UnitedStates-cb-label-CountryFilter']")
    private WebElement usaCheckBox;

    @FindBy(xpath = "//body/div[@id='wd-site-page']/div[2]/aside[1]/div[4]/div[1]/div[2]/div[2]/button[1]")
    private WebElement countryUpdateButton;

    @FindBy(xpath = "//a[contains(text(),'Activision Blizzard Inc')]")
    private WebElement companyActivisionBlizzardIncLink;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(SERVER_URL);

     /*   driver.findElement(By.xpath("//div[@id='filter-country']//label[@id='Belgium-cb-label-CountryFilter']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/div[@id='wd-site-page']/div[2]/aside[1]/div[4]/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(5000);*/

        driver.findElement(By.xpath("//div[@id='filter-country']//label[@id='UnitedStates-cb-label-CountryFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='wd-site-page']/div[2]/aside[1]/div[4]/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Activision Blizzard Inc')]")).click();
        System.out.println("*****"+driver.findElement(By.xpath("//div[@id=\"dv-meetings-available\"]//div//h2")).getAttribute("innerHTML").trim());
        String s =driver.findElement(By.tagName("h2")).getText();
        System.out.println("*****"+s);
        Thread.sleep(2000);
        driver.quit();

    }
}
