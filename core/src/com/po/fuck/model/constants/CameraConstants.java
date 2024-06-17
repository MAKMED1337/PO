package com.po.fuck.model.constants;

import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;

import java.nio.file.Paths;
import java.util.Properties;

public final class CameraConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/camera.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final float SPEED = loadFloat(PROPERTIES, "SPEED");
}
