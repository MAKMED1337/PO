package com.po.fuck.model.constants;

import java.util.Properties;

import static com.po.fuck.model.constants.ConstantsLoader.loadProperties;
import static com.po.fuck.model.constants.ConstantsLoader.loadConstant;

public final class BalanceConstants extends BaseConstants {
    static final String BALANCE_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/balance.properties";
    static final Properties BALANCE_PROPERTIES = loadProperties(BALANCE_PROPERTIES_PATH);

    public static final float BASIC_ENEMY_SPEED = loadConstant("BASIC_ENEMY_SPEED", Float.class, BALANCE_PROPERTIES);
    public static final float BASIC_ENEMY_HEALTH = loadConstant("BASIC_ENEMY_HEALTH", Float.class, BALANCE_PROPERTIES);
    public static final int BASIC_ENEMY_REWARD = loadConstant("BASIC_ENEMY_REWARD", Integer.class, BALANCE_PROPERTIES);
    public static final float PLAYERS_HEALTH = loadConstant("PLAYERS_HEALTH", Float.class, BALANCE_PROPERTIES);

    public static Properties getProperties() {
        Properties properties = new Properties();
        addProperty(properties, "BASIC_ENEMY_SPEED", BASIC_ENEMY_SPEED);
        addProperty(properties, "BASIC_ENEMY_HEALTH", BASIC_ENEMY_HEALTH);
        addProperty(properties, "BASIC_ENEMY_REWARD", BASIC_ENEMY_REWARD);
        addProperty(properties, "PLAYERS_HEALTH", PLAYERS_HEALTH);
        return properties;
    }
}