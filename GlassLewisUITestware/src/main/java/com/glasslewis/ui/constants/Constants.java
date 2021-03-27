package com.glasslewis.ui.constants;

public class Constants {

    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String CHROME_DRIVER = USER_DIRECTORY + "/src/main/resources/drivers/chromedriver.exe";
    public static final String FIREFOX_DRIVER = USER_DIRECTORY + "/src/main/resources/drivers/geckodriver.exe";
    public static final String CONFIG_FILE = USER_DIRECTORY + "/src/main/resources/config.properties";
    public static final String CHROME_LOGFILE = "logs/chromelogs.txt";
    public static final String FIREFOX_LOGFILE = "logs/firefoxlogs.txt";
    public static final String SCREENSHOT_DIR = USER_DIRECTORY + "/FailedTestsScreenshots/";
    public static final String REPORT_DIR = USER_DIRECTORY + "/ExtentReportResults/";
    public static final long PAGE_LOAD_TIMEOUT = 30;
    public static final long IMPLICIT_WAIT = 30;
    public static final long EXPLICT_WAIT = 60;
    public static final String SERVER_URL = "https://viewpoint.glasslewis.com/WD/?siteId=DemoClient";

    private Constants() {
    }
}
