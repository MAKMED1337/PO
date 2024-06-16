package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;

public final class PositionConstants extends BaseConstants {
    private static final String BULLETS_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/position.properties").toString();
    private static final Properties BULLETS_PROPERTIES = loadProperties(BULLETS_PROPERTIES_PATH);

    public static final float DEFAULT_DISTANCE_FACTOR       = loadFloat(BULLETS_PROPERTIES, "DEFAULT_DISTANCE_FACTOR");
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadFloat(BULLETS_PROPERTIES, "DEFAULT_MAX_DISTANCE_FROM_BODY");
}