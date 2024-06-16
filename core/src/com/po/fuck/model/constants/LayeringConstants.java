package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class LayeringConstants extends BaseConstants {
    static final String LAYERING_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/layering.properties";
    static final Properties LAYERING_PROPERTIES = loadProperties(LAYERING_PROPERTIES_PATH);

    public static final int BACKGROUND_LAYER = loadInt("BACKGROUND_LAYER", LAYERING_PROPERTIES);
    public static final int ENTITY_LAYER = loadInt("ENTITY_LAYER", LAYERING_PROPERTIES);
    public static final int WEAPON_LAYER = loadInt("WEAPON_LAYER", LAYERING_PROPERTIES);
    public static final int GUI_LAYER = loadInt("GUI_LAYER", LAYERING_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "BACKGROUND_LAYER", BACKGROUND_LAYER);
        addProperty(properties, "ENTITY_LAYER", ENTITY_LAYER);
        addProperty(properties, "WEAPON_LAYER", WEAPON_LAYER);
        addProperty(properties, "GUI_LAYER", GUI_LAYER);
        return properties;
    }
}