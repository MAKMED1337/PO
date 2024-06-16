package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class PhysicsConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/physics.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int COLLISION_ITERATIONS = loadInt(PROPERTIES, "COLLISION_ITERATIONS");
}
