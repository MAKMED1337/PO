package com.po.fuck.model.constants;

import java.nio.file.Paths;
import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadFloat;
import static com.po.fuck.model.constants.ConstantsLoader.loadInt;

public final class BalanceConstants extends BaseConstants {
    static final String BALANCE_PROPERTIES_PATH = Paths.get(PROPERTIES_FOLDER, "/balance.properties").toString();
    static final Properties BALANCE_PROPERTIES = loadProperties(BALANCE_PROPERTIES_PATH);

    public static final float   BASIC_ENEMY_SPEED   = loadFloat("BASIC_ENEMY_SPEED", BALANCE_PROPERTIES);
    public static final float   BASIC_ENEMY_HEALTH  = loadFloat("BASIC_ENEMY_HEALTH", BALANCE_PROPERTIES);
    public static final int     BASIC_ENEMY_REWARD  = loadInt("BASIC_ENEMY_REWARD", BALANCE_PROPERTIES);
    public static final float   PLAYERS_HEALTH      = loadFloat("PLAYERS_HEALTH", BALANCE_PROPERTIES);

    public static final float   DEFAULT_SPEED   = loadFloat("DEFAULT_SPEED", BALANCE_PROPERTIES);
    public static final int     BOOST_DISTANCE  = loadInt("BOOST_DISTANCE", BALANCE_PROPERTIES);
    public static final float   BOOST_DURATION  = loadFloat("BOOST_DURATION", BALANCE_PROPERTIES);
    public static final float   BOOST_COOLDOWN  = loadFloat("BOOST_COOLDOWN", BALANCE_PROPERTIES);
}