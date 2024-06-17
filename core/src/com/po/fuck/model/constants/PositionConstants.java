package com.po.fuck.model.constants;

import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;

import java.nio.file.Paths;
import java.util.Properties;

public final class PositionConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/position.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final float DEFAULT_DISTANCE_FACTOR = loadFloat(PROPERTIES, "DEFAULT_DISTANCE_FACTOR");
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadFloat(PROPERTIES, "DEFAULT_MAX_DISTANCE_FROM_BODY");
}
