package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;


public final class BordersConstants extends BaseConstants {
    static final String BORDERS_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/borders.properties").toString();
    static final Properties BORDERS_PROPERTIES = loadProperties(BORDERS_PROPERTIES_PATH);

    public static final int GAME_BORDER = loadInt("GAME_BORDER", BORDERS_PROPERTIES);
}