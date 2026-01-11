package com.ayush.automation.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        try {
            prop = new Properties();
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found in resources");
            }

            prop.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
