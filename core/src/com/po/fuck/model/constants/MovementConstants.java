package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class MovementConstants extends BaseConstants {
    static final String MOVEMENT_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/movement.properties";
    static final Properties MOVEMENT_PROPERTIES = loadProperties(MOVEMENT_PROPERTIES_PATH);

    public static final float DEFAULT_SPEED = loadConstant("DEFAULT_SPEED", Float.class, MOVEMENT_PROPERTIES);
    public static final int BOOST_DISTANCE = loadConstant("BOOST_DISTANCE", Integer.class, MOVEMENT_PROPERTIES);
    public static final float BOOST_DURATION = loadConstant("BOOST_DURATION", Float.class, MOVEMENT_PROPERTIES);
    public static final float BOOST_COOLDOWN = loadConstant("BOOST_COOLDOWN", Float.class, MOVEMENT_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "DEFAULT_SPEED", DEFAULT_SPEED);
        addProperty(properties, "BOOST_DISTANCE", BOOST_DISTANCE);
        addProperty(properties, "BOOST_DURATION", BOOST_DURATION);
        addProperty(properties, "BOOST_COOLDOWN", BOOST_COOLDOWN);
        return properties;
    }
}
