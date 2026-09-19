package com.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesRead {
    public static Properties prop;

    public static Properties readProperties() {
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}