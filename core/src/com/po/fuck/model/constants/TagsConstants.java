package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class TagsConstants extends BaseConstants {
    private static final String TAGS_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/tags.properties").toString();
    private static final Properties TAGS_PROPERTIES = loadProperties(TAGS_PROPERTIES_PATH);

    public static final int ENEMY_TEAM_TAG = loadInt(TAGS_PROPERTIES, "ENEMY_TEAM_TAG");
    public static final int PLAYER_TEAM_TAG = loadInt(TAGS_PROPERTIES, "PLAYER_TEAM_TAG");
}