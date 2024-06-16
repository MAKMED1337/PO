package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class CameraConstants extends BaseConstants {
    static final String CAMERA_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/camera.properties";
    static final Properties CAMERA_PROPERTIES = loadProperties(CAMERA_PROPERTIES_PATH);

    public static final float CAMERA_SPEED = loadConstant("CAMERA_SPEED", Float.class, CAMERA_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "CAMERA_SPEED", CAMERA_SPEED);
        return properties;
    }
}