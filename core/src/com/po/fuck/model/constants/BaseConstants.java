package com.po.fuck.model.constants;

import java.util.Properties;

public class BaseConstants {
    static final String PROPERTIES_FOLDER = "../core/src/com/po/fuck/properties";
    protected static <T> void addProperty(Properties properties, String name, T value) {
        properties.setProperty(name, value.toString());
    }
}
