package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class GameConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/game.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int SCREEN_WIDTH    = loadInt(PROPERTIES, "SCREEN_WIDTH");
    public static final int SCREEN_HEIGHT   = loadInt(PROPERTIES, "SCREEN_HEIGHT");
}
