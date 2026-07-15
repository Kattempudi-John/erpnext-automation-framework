package com.erpTechnologies.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        properties = new Properties();

        try{
            FileInputStream fileInputStream =
                    new FileInputStream("src/main/resources/config.properties");

            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
