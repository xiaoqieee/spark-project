package com.hawcore.sparkproject.conf;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author fengq
 */
public class ConfigurationManager {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream in = ConfigurationManager.class.getClassLoader().getResourceAsStream("my.properties");
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Integer getInteger(String key) {
        String value = getProperty(key);
        if (null != value) {
            return Integer.valueOf(value);
        }
        return null;
    }
}
