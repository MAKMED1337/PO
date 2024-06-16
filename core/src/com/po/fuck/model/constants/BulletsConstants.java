package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class BulletsConstants extends BaseConstants {
    static final String BULLETS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/bullets.properties";
    static final Properties BULLETS_PROPERTIES = loadProperties(BULLETS_PROPERTIES_PATH);

    public static final float COSMIC_BULLET_LIFE_TIME = loadConstant("COSMIC_BULLET_LIFE_TIME", Float.class, BULLETS_PROPERTIES);
    public static final float COSMIC_BULLET_DAMAGE = loadConstant("COSMIC_BULLET_DAMAGE", Float.class, BULLETS_PROPERTIES);
    public static final float COSMIC_BULLET_SPEED = loadConstant("COSMIC_BULLET_SPEED", Float.class, BULLETS_PROPERTIES);
    public static final float LASER_BEAM_DAMAGE = loadConstant("LASER_BEAM_DAMAGE", Float.class, BULLETS_PROPERTIES);
    public static final float LASER_BEAM_LIFE_TIME = loadConstant("LASER_BEAM_LIFE_TIME", Float.class, BULLETS_PROPERTIES);
    public static final float DEFAULT_BULLET_LIFE_TIME = loadConstant("DEFAULT_BULLET_LIFE_TIME", Float.class, BULLETS_PROPERTIES);
    public static final float GLOCK_COOLDOWN = loadConstant("GLOCK_COOLDOWN", Float.class, BULLETS_PROPERTIES);
    public static final float LASERGUN_COOLDOWN = loadConstant("LASERGUN_COOLDOWN", Float.class, BULLETS_PROPERTIES);
    public static final float DEFAULT_DISTANCE_FACTOR = loadConstant("DEFAULT_DISTANCE_FACTOR", Float.class, BULLETS_PROPERTIES);
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadConstant("DEFAULT_MAX_DISTANCE_FROM_BODY", Float.class, BULLETS_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "COSMIC_BULLET_LIFE_TIME", COSMIC_BULLET_LIFE_TIME);
        addProperty(properties, "COSMIC_BULLET_DAMAGE", COSMIC_BULLET_DAMAGE);
        addProperty(properties, "COSMIC_BULLET_SPEED", COSMIC_BULLET_SPEED);
        addProperty(properties, "LASER_BEAM_DAMAGE", LASER_BEAM_DAMAGE);
        addProperty(properties, "LASER_BEAM_LIFE_TIME", LASER_BEAM_LIFE_TIME);
        addProperty(properties, "DEFAULT_BULLET_LIFE_TIME", DEFAULT_BULLET_LIFE_TIME);
        addProperty(properties, "GLOCK_COOLDOWN", GLOCK_COOLDOWN);
        addProperty(properties, "LASERGUN_COOLDOWN", LASERGUN_COOLDOWN);
        addProperty(properties, "DEFAULT_DISTANCE_FACTOR", DEFAULT_DISTANCE_FACTOR);
        addProperty(properties, "DEFAULT_MAX_DISTANCE_FROM_BODY", DEFAULT_MAX_DISTANCE_FROM_BODY);
        return properties;
    }
}