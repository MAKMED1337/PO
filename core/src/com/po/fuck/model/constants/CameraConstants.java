package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;;

public final class CameraConstants extends BaseConstants {
    private static final String CAMERA_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/camera.properties").toString();
    private static final Properties CAMERA_PROPERTIES = loadProperties(CAMERA_PROPERTIES_PATH);

    public static final float CAMERA_SPEED = loadFloat(CAMERA_PROPERTIES, "CAMERA_SPEED");
}