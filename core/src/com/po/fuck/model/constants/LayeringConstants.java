package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class LayeringConstants extends BaseConstants {
    static final String LAYERING_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/layering.properties").toString();
    static final Properties LAYERING_PROPERTIES = loadProperties(LAYERING_PROPERTIES_PATH);

    public static final int BACKGROUND_LAYER = loadInt("BACKGROUND_LAYER", LAYERING_PROPERTIES);
    public static final int ENTITY_LAYER = loadInt("ENTITY_LAYER", LAYERING_PROPERTIES);
    public static final int WEAPON_LAYER = loadInt("WEAPON_LAYER", LAYERING_PROPERTIES);
    public static final int GUI_LAYER = loadInt("GUI_LAYER", LAYERING_PROPERTIES);
}