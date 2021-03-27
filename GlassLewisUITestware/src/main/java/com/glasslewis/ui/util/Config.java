package com.glasslewis.ui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glasslewis.ui.constants.Constants;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    static Properties properties = new Properties();

    static {
        TestUtil.setDateForLog4j();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(Constants.CONFIG_FILE);
            properties.load(ip);
            logger.debug("config.properties file is read successfully");
        } catch (FileNotFoundException e) {
            logger.error("config.properties not found {}", e);
        } catch (IOException e) {
            logger.error("Failed to read config.properties {}", e);
        }
    }

    private Config() {
    }

    public static String getProperty(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : properties.getProperty(key);
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }



}
