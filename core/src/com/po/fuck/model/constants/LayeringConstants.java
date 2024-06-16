package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class LayeringConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/layering.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int BACKGROUND    = loadInt(PROPERTIES, "BACKGROUND_LAYER");
    public static final int ENTITY        = loadInt(PROPERTIES, "ENTITY_LAYER");
    public static final int WEAPON        = loadInt(PROPERTIES, "WEAPON_LAYER");
    public static final int GUI           = loadInt(PROPERTIES, "GUI_LAYER");
}