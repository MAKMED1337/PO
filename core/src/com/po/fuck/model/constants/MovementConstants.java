package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;

public final class MovementConstants extends BaseConstants {
    static final String MOVEMENT_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/movement.properties").toString();
    static final Properties MOVEMENT_PROPERTIES = loadProperties(MOVEMENT_PROPERTIES_PATH);

    public static final float DEFAULT_SPEED = loadFloat("DEFAULT_SPEED", MOVEMENT_PROPERTIES);
    public static final int BOOST_DISTANCE = loadInt("BOOST_DISTANCE", MOVEMENT_PROPERTIES);
    public static final float BOOST_DURATION = loadFloat("BOOST_DURATION", MOVEMENT_PROPERTIES);
    public static final float BOOST_COOLDOWN = loadFloat("BOOST_COOLDOWN", MOVEMENT_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "DEFAULT_SPEED", DEFAULT_SPEED);
        addProperty(properties, "BOOST_DISTANCE", BOOST_DISTANCE);
        addProperty(properties, "BOOST_DURATION", BOOST_DURATION);
        addProperty(properties, "BOOST_COOLDOWN", BOOST_COOLDOWN);
        return properties;
    }
}
