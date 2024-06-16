package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class LayeringConstants extends BaseConstants {
    static final String LAYERING_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/layering.properties";
    static final Properties LAYERING_PROPERTIES = loadProperties(LAYERING_PROPERTIES_PATH);

    public static final int BACKGROUND_LAYER = loadConstant("BACKGROUND_LAYER", Integer.class, LAYERING_PROPERTIES);
    public static final int ENTITY_LAYER = loadConstant("ENTITY_LAYER", Integer.class, LAYERING_PROPERTIES);
    public static final int WEAPON_LAYER = loadConstant("WEAPON_LAYER", Integer.class, LAYERING_PROPERTIES);
    public static final int GUI_LAYER = loadConstant("GUI_LAYER", Integer.class, LAYERING_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "BACKGROUND_LAYER", BACKGROUND_LAYER);
        addProperty(properties, "ENTITY_LAYER", ENTITY_LAYER);
        addProperty(properties, "WEAPON_LAYER", WEAPON_LAYER);
        addProperty(properties, "GUI_LAYER", GUI_LAYER);
        return properties;
    }
}