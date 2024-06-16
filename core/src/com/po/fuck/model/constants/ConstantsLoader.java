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
    protected static <T> T loadConstant(String name, Class<T> cls, Properties properties) {
        String value = properties.getProperty(name);
        if(value == null)
            throw new RuntimeException(cls.toString() + name + " is null");
        if (cls == Integer.class) {
            return cls.cast(Integer.valueOf(value));
        } else if (cls == Float.class) {
            return cls.cast(Float.valueOf(value));
        } else {
            throw new IllegalArgumentException("Unsupported property type");
        }
    }
}
