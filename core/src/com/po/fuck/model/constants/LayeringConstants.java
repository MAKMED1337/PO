package com.po.fuck.model.constants;

import static com.po.fuck.model.constants.ConstantsLoader.loadInt;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;

import java.nio.file.Paths;
import java.util.Properties;

public final class LayeringConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/layering.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int BACKGROUND = loadInt(PROPERTIES, "BACKGROUND");
    public static final int ENTITY = loadInt(PROPERTIES, "ENTITY");
    public static final int WEAPON = loadInt(PROPERTIES, "WEAPON");
    public static final int GUI = loadInt(PROPERTIES, "GUI");
}
