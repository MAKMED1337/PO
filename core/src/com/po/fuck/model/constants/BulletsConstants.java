package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;

public final class BulletsConstants extends BaseConstants {
    static final String BULLETS_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/bullets.properties").toString();
    static final Properties BULLETS_PROPERTIES = loadProperties(BULLETS_PROPERTIES_PATH);

    public static final float COSMIC_BULLET_LIFE_TIME       = loadFloat("COSMIC_BULLET_LIFE_TIME", BULLETS_PROPERTIES);
    public static final float COSMIC_BULLET_DAMAGE          = loadFloat("COSMIC_BULLET_DAMAGE", BULLETS_PROPERTIES);
    public static final float COSMIC_BULLET_SPEED           = loadFloat("COSMIC_BULLET_SPEED", BULLETS_PROPERTIES);
    public static final float LASER_BEAM_DAMAGE             = loadFloat("LASER_BEAM_DAMAGE", BULLETS_PROPERTIES);
    public static final float LASER_BEAM_LIFE_TIME          = loadFloat("LASER_BEAM_LIFE_TIME", BULLETS_PROPERTIES);
    public static final float DEFAULT_BULLET_LIFE_TIME      = loadFloat("DEFAULT_BULLET_LIFE_TIME", BULLETS_PROPERTIES);
    public static final float GLOCK_COOLDOWN                = loadFloat("GLOCK_COOLDOWN", BULLETS_PROPERTIES);
    public static final float LASERGUN_COOLDOWN             = loadFloat("LASERGUN_COOLDOWN", BULLETS_PROPERTIES);
    public static final float DEFAULT_DISTANCE_FACTOR       = loadFloat("DEFAULT_DISTANCE_FACTOR", BULLETS_PROPERTIES);
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadFloat("DEFAULT_MAX_DISTANCE_FROM_BODY", BULLETS_PROPERTIES);
}