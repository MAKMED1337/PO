package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class PhysicsConstants extends BaseConstants {
    static final String PHYSICS_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/physics.properties").toString();
    static final Properties PHYSICS_PROPERTIES = loadProperties(PHYSICS_PROPERTIES_PATH);

    public static final int COLLISION_ITERATIONS = loadInt("COLLISION_ITERATIONS", PHYSICS_PROPERTIES);
}
