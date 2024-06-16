package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class GameConstants extends BaseConstants {
    static final String GAME_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/game.properties").toString();
    static final Properties GAME_PROPERTIES = loadProperties(GAME_PROPERTIES_PATH);

    public static final int SCREEN_WIDTH    = loadInt("SCREEN_WIDTH", GAME_PROPERTIES);
    public static final int SCREEN_HEIGHT   = loadInt("SCREEN_HEIGHT", GAME_PROPERTIES);
}
