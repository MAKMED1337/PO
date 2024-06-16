package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class PhysicsConstants extends BaseConstants {
    static final String PHYSICS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/physics.properties";
    static final Properties PHYSICS_PROPERTIES = loadProperties(PHYSICS_PROPERTIES_PATH);

    public static final int COLLISION_ITERATIONS = loadInt("COLLISION_ITERATIONS", PHYSICS_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "COLLISION_ITERATIONS", COLLISION_ITERATIONS);
        return properties;
    }
}
