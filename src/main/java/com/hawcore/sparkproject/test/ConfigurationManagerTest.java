package com.hawcore.sparkproject.test;

import com.hawcore.sparkproject.conf.ConfigurationManager;

public class ConfigurationManagerTest {

    public static void main(String[] args) {
        System.out.println(ConfigurationManager.getProperty("key1"));
        System.out.println(ConfigurationManager.getProperty("key2"));
    }
}
