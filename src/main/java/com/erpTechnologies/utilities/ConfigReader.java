package com.erpTechnologies.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConfigReader {

    private static final Logger logger =
            LogManager.getLogger(ConfigReader.class);

    private static Properties properties;

    static {
        properties = new Properties();

        logger.info("Loading configuration file...");

        try{FileInputStream fileInputStream =
                    new FileInputStream("src/main/resources/config.properties");

            properties.load(fileInputStream);

            logger.info("Configuration loaded successfully.");

        } catch (IOException e) {

            logger.error("Failed to load configuration file.", e);

            throw new RuntimeException("Failed to load config.properties file", e);
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
