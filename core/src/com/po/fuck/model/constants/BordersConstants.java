package com.po.fuck.model.constants;

import java.util.Properties;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;


public final class BordersConstants extends BaseConstants {
    static final String BORDERS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/borders.properties";
    static final Properties BORDERS_PROPERTIES = loadProperties(BORDERS_PROPERTIES_PATH);

    public static final int GAME_BORDER = loadInt("GAME_BORDER", BORDERS_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "GAME_BORDER", GAME_BORDER);
        return properties;
    }
}