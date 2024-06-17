package com.po.fuck.view;

import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;
import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadVec;

import java.nio.file.Paths;
import java.util.Properties;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.constants.BaseConstants;

public final class RenderConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/render.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final int WIDTH = loadInt(PROPERTIES, "WIDTH");
    public static final int HEIGHT = loadInt(PROPERTIES, "HEIGHT");

    /* health bar */
    public static final float HEALTHBAR_OFFSET = loadInt(PROPERTIES, "HEALTHBAR_OFFSET");
    public static final int HEALTHBAR_WIDTH = loadInt(PROPERTIES, "HEALTHBAR_WIDTH");
    public static final int HEALTHBAR_HEIGHT = loadInt(PROPERTIES, "HEALTHBAR_HEIGHT");

    /* coins */
    public static final Vector2 COIN_SPRITE_POSITION = loadVec(PROPERTIES, "COIN_SPRITE_POSITION");
    public static final Vector2 COINS_COUNTER_POSITION = loadVec(PROPERTIES, "COINS_COUNTER_POSITION");
    public static final float WIDTH_OF_THE_COIN_COUNTER_DIGIT = loadFloat(PROPERTIES,
            "WIDTH_OF_THE_COIN_COUNTER_DIGIT");
    public static final float COINS_COUNTER_TEXT_SCALE = loadFloat(PROPERTIES, "COINS_COUNTER_TEXT_SCALE");
}
