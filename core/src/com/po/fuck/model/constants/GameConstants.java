package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class GameConstants extends BaseConstants {
    static final String GAME_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/game.properties";
    static final Properties GAME_PROPERTIES = loadProperties(GAME_PROPERTIES_PATH);

    public static final int SCREEN_WIDTH = loadConstant("SCREEN_WIDTH", Integer.class, GAME_PROPERTIES);
    public static final int SCREEN_HEIGHT = loadConstant("SCREEN_HEIGHT", Integer.class, GAME_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "SCREEN_WIDTH", SCREEN_WIDTH);
        addProperty(properties, "SCREEN_HEIGHT", SCREEN_HEIGHT);
        return properties;
    }
}
