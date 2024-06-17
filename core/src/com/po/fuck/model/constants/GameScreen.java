package com.po.fuck.model.constants;

import static com.po.fuck.model.constants.ConstantsLoader.loadInt;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;

import java.nio.file.Paths;
import java.util.Properties;

public final class GameScreen extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/gamescreen.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int WIDTH = loadInt(PROPERTIES, "WIDTH");
    public static final int HEIGHT = loadInt(PROPERTIES, "HEIGHT");
}
