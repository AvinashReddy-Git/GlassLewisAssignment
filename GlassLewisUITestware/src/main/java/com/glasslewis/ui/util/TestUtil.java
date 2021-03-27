package com.glasslewis.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

    public static void setDateForLog4j() {
        System.setProperty("current_date", getTime());
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }

    public static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            if (fileInputStreamReader.read(bytes) > 0) {
                encodedfile = new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
            }
        } catch (FileNotFoundException e) {
            logger.error("{} File not found", file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return encodedfile;
    }

}