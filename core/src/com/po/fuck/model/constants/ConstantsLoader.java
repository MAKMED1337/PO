package com.po.fuck.model.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConstantsLoader {
    protected static Properties loadProperties(String filePath) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(filePath));
            return properties;
        } catch (IOException io) {
            throw new RuntimeException("Unable to load properties file: " + filePath + " - " + io.getMessage());
        }
    }

    protected static String loadConstant(Properties properties, String name) {
        String value = properties.getProperty(name);
        if(value == null)
            throw new RuntimeException(name + " is null");
        return value;
    }

    protected static int loadInt(Properties properties, String name){
        return Integer.valueOf(loadConstant(properties, name));
    }

    protected static float loadFloat(Properties properties, String name){
        return Float.valueOf(loadConstant(properties, name));
    }
}
