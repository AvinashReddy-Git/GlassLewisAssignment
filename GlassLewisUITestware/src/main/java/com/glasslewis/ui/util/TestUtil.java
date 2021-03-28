package com.glasslewis.ui.util;

import static com.glasslewis.ui.constants.Constants.EXPLICT_WAIT;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glasslewis.ui.constants.Constants;

public class TestUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestUtil.class);

    private TestUtil() {

    }

    public static String takeScreenshot(WebDriver driver, String imageName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dstFile = Constants.SCREENSHOT_DIR + imageName + "_" + getTime() + ".png";
        FileUtils.copyFile(scrFile, new File(dstFile));
        String base64Image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + base64Image;
    }

    public static String getTime() {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmm");
        return sdf.format(calender.getTime());
    }


}