package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class BalanceConstants extends BaseConstants {
    private static final String PATH = Paths.get(PROPERTIES_FOLDER, "/balance.properties").toString();
    private static final Properties PROPERTIES = loadProperties(PATH);

    public static final float   BASIC_ENEMY_SPEED   = loadFloat(PROPERTIES, "BASIC_ENEMY_SPEED");
    public static final float   BASIC_ENEMY_HEALTH  = loadFloat(PROPERTIES, "BASIC_ENEMY_HEALTH");
    public static final int     BASIC_ENEMY_REWARD  = loadInt(PROPERTIES, "BASIC_ENEMY_REWARD");
    public static final float   PLAYERS_HEALTH      = loadFloat(PROPERTIES, "PLAYERS_HEALTH");

    public static final float   DEFAULT_SPEED   = loadFloat(PROPERTIES, "DEFAULT_SPEED");
    public static final int     BOOST_DISTANCE  = loadInt(PROPERTIES, "BOOST_DISTANCE");
    public static final float   BOOST_DURATION  = loadFloat(PROPERTIES, "BOOST_DURATION");
    public static final float   BOOST_COOLDOWN  = loadFloat(PROPERTIES, "BOOST_COOLDOWN");

    public static final float COSMIC_BULLET_LIFE_TIME       = loadFloat(PROPERTIES, "COSMIC_BULLET_LIFE_TIME");
    public static final float COSMIC_BULLET_DAMAGE          = loadFloat(PROPERTIES, "COSMIC_BULLET_DAMAGE");
    public static final float COSMIC_BULLET_SPEED           = loadFloat(PROPERTIES, "COSMIC_BULLET_SPEED");
    public static final float LASER_BEAM_DAMAGE             = loadFloat(PROPERTIES, "LASER_BEAM_DAMAGE");
    public static final float LASER_BEAM_LIFE_TIME          = loadFloat(PROPERTIES, "LASER_BEAM_LIFE_TIME");
    public static final float DEFAULT_BULLET_LIFE_TIME      = loadFloat(PROPERTIES, "DEFAULT_BULLET_LIFE_TIME");
    public static final float GLOCK_COOLDOWN                = loadFloat(PROPERTIES, "GLOCK_COOLDOWN");
    public static final float LASERGUN_COOLDOWN             = loadFloat(PROPERTIES, "LASERGUN_COOLDOWN");
}