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
        String value = properties.getProperty(key);
        if (null != value) {
            return value;
        }
        throw new RuntimeException("必须配置:" + key);
    }

    public static int getInteger(String key) {
        String value = getProperty(key);
        return Integer.valueOf(value);
    }

    public static boolean getBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }
}
