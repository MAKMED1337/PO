package com.po.fuck.model.constants;

import java.util.Properties;

public class BaseConstants {
    protected static <T> void addProperty(Properties properties, String name, T value) {
        properties.setProperty(name, value.toString());
    }
}
