package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class TagsConstants extends BaseConstants {
    static final String TAGS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/tags.properties";
    static final Properties TAGS_PROPERTIES = loadProperties(TAGS_PROPERTIES_PATH);

    public static final int ENEMY_TEAM_TAG = loadInt("ENEMY_TEAM_TAG", TAGS_PROPERTIES);
    public static final int PLAYER_TEAM_TAG = loadInt("PLAYER_TEAM_TAG", TAGS_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "ENEMY_TEAM_TAG", ENEMY_TEAM_TAG);
        addProperty(properties, "PLAYER_TEAM_TAG", PLAYER_TEAM_TAG);
        return properties;
    }
}