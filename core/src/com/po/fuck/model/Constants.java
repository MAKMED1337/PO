package com.po.fuck.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public final class Constants {
    static Properties properties = null;

    static <T> T loadConstant(String name, Class<T> cls){
        if(properties == null){
            properties = new Properties();
            try {
                properties.load(new FileInputStream("../core/src/com/po/fuck/model/.properties"));
            } catch(IOException io){
                throw new RuntimeException(io.getMessage());
            }
        }
        String value = properties.getProperty(name);
        if(value == null){
            throw new RuntimeException(cls.getName() + name + " is not found in .properties");
        }
        if (cls == Integer.class) {
            return cls.cast(Integer.valueOf(value));
        } else if (cls == Float.class) {
            return cls.cast(Float.valueOf(value));
        } else {
            throw new IllegalArgumentException("Unsupported property type");
        }
    }

    public static final int SCREEN_WIDTH = loadConstant("SCREEN_WIDTH", Integer.class);
    public static final int SCREEN_HEIGHT = loadConstant("SCREEN_HEIGHT", Integer.class);

    /* movement */
    public static final float DEFAULT_SPEED = loadConstant("DEFAULT_SPEED", Float.class);
    public static final int BOOST_DISTANCE = loadConstant("BOOST_DISTANCE", Integer.class);
    public static final float BOOST_DURATION = loadConstant("BOOST_DURATION", Float.class);
    public static final float BOOST_COOLDOWN = loadConstant("BOOST_COOLDOWN", Float.class);

    /* physics */
    public static final int COLLISION_ITERATIONS = loadConstant("COLLISION_ITERATIONS", Integer.class);

    /* team tags */
    public static final int ENEMY_TEAM_TAG = loadConstant("ENEMY_TEAM_TAG", Integer.class);
    public static final int PLAYER_TEAM_TAG = loadConstant("PLAYER_TEAM_TAG", Integer.class);

    /* camera */
    public static final float CAMERA_SPEED = loadConstant("CAMERA_SPEED", Float.class);

    /* layering */
    public static final int BACKGROUND_LAYER = loadConstant("BACKGROUND_LAYER", Integer.class);
    public static final int ENTITY_LAYER = loadConstant("ENTITY_LAYER", Integer.class);
    public static final int WEAPON_LAYER = loadConstant("WEAPON_LAYER", Integer.class);
    public static final int GUI_LAYER = loadConstant("GUI_LAYER", Integer.class);

    /* borders */
    public static final int GAME_BORDER = loadConstant("GAME_BORDER", Integer.class);

    /* bullets */
    public static final float COSMIC_BULLET_LIFE_TIME = loadConstant("COSMIC_BULLET_LIFE_TIME", Float.class);
    public static final float COSMIC_BULLET_DAMAGE = loadConstant("COSMIC_BULLET_DAMAGE", Float.class);
    public static final float COSMIC_BULLET_SPEED = loadConstant("COSMIC_BULLET_SPEED", Float.class);
    public static final float LASER_BEAM_DAMAGE = loadConstant("LASER_BEAM_DAMAGE", Float.class);
    public static final float LASER_BEAM_LIFE_TIME = loadConstant("LASER_BEAM_LIFE_TIME", Float.class);
    public static final float DEFAULT_BULLET_LIFE_TIME = loadConstant("DEFAULT_BULLET_LIFE_TIME", Float.class);

    public static final float GLOCK_COOLDOWN = loadConstant("GLOCK_COOLDOWN", Float.class);
    public static final float LASERGUN_COOLDOWN = loadConstant("LASERGUN_COOLDOWN", Float.class);

    public static final float PLAYERS_HEALTH = loadConstant("PLAYERS_HEALTH", Float.class);

    public static final float DEFAULT_DISTANCE_FACTOR = loadConstant("DEFAULT_DISTANCE_FACTOR", Float.class);
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadConstant("DEFAULT_MAX_DISTANCE_FROM_BODY", Float.class);

    public static final float BASIC_ENEMY_SPEED = loadConstant("BASIC_ENEMY_SPEED", Float.class);
    public static final float BASIC_ENEMY_HEALTH = loadConstant("BASIC_ENEMY_HEALTH", Float.class);
    public static final int BASIC_ENEMY_REWARD = loadConstant("BASIC_ENEMY_REWARD", Integer.class);

    public static void saveToProperties() {
        String propertiesFilePath = "../core/src/com/po/fuck/model/.properties";
    
        // Ensure the file exists or create it if it doesn't
        File propertiesFile = new File(propertiesFilePath);
        if (!propertiesFile.exists()) {
            try {
                propertiesFile.getParentFile().mkdirs(); // Create parent directories if they don't exist
                propertiesFile.createNewFile(); // Create the file
            } catch (IOException e) {
                throw new RuntimeException("Unable to create properties file: " + e.getMessage());
            }
        }

        try (OutputStream output = new FileOutputStream(propertiesFilePath)) {
            Properties prop = new Properties();

            prop.setProperty("SCREEN_WIDTH", Integer.toString(SCREEN_WIDTH));
            prop.setProperty("SCREEN_HEIGHT", Integer.toString(SCREEN_HEIGHT));
            prop.setProperty("DEFAULT_SPEED", Float.toString(DEFAULT_SPEED));
            prop.setProperty("BOOST_DISTANCE", Integer.toString(BOOST_DISTANCE));
            prop.setProperty("BOOST_DURATION", Float.toString(BOOST_DURATION));
            prop.setProperty("BOOST_COOLDOWN", Float.toString(BOOST_COOLDOWN));
            prop.setProperty("COLLISION_ITERATIONS", Integer.toString(COLLISION_ITERATIONS));
            prop.setProperty("ENEMY_TEAM_TAG", Integer.toString(ENEMY_TEAM_TAG));
            prop.setProperty("PLAYER_TEAM_TAG", Integer.toString(PLAYER_TEAM_TAG));
            prop.setProperty("CAMERA_SPEED", Float.toString(CAMERA_SPEED));
            prop.setProperty("BACKGROUND_LAYER", Integer.toString(BACKGROUND_LAYER));
            prop.setProperty("ENTITY_LAYER", Integer.toString(ENTITY_LAYER));
            prop.setProperty("WEAPON_LAYER", Integer.toString(WEAPON_LAYER));
            prop.setProperty("GUI_LAYER", Integer.toString(GUI_LAYER));
            prop.setProperty("GAME_BORDER", Integer.toString(GAME_BORDER));
            prop.setProperty("COSMIC_BULLET_LIFE_TIME", Float.toString(COSMIC_BULLET_LIFE_TIME));
            prop.setProperty("COSMIC_BULLET_DAMAGE", Float.toString(COSMIC_BULLET_DAMAGE));
            prop.setProperty("COSMIC_BULLET_SPEED", Float.toString(COSMIC_BULLET_SPEED));
            prop.setProperty("LASER_BEAM_DAMAGE", Float.toString(LASER_BEAM_DAMAGE));
            prop.setProperty("LASER_BEAM_LIFE_TIME", Float.toString(LASER_BEAM_LIFE_TIME));
            prop.setProperty("DEFAULT_BULLET_LIFE_TIME", Float.toString(DEFAULT_BULLET_LIFE_TIME));
            prop.setProperty("GLOCK_COOLDOWN", Float.toString(GLOCK_COOLDOWN));
            prop.setProperty("LASERGUN_COOLDOWN", Float.toString(LASERGUN_COOLDOWN));
            prop.setProperty("PLAYERS_HEALTH", Float.toString(PLAYERS_HEALTH));
            prop.setProperty("DEFAULT_DISTANCE_FACTOR", Float.toString(DEFAULT_DISTANCE_FACTOR));
            prop.setProperty("DEFAULT_MAX_DISTANCE_FROM_BODY", Float.toString(DEFAULT_MAX_DISTANCE_FROM_BODY));
            prop.setProperty("BASIC_ENEMY_SPEED", Float.toString(BASIC_ENEMY_SPEED));
            prop.setProperty("BASIC_ENEMY_HEALTH", Float.toString(BASIC_ENEMY_HEALTH));
            prop.setProperty("BASIC_ENEMY_REWARD", Integer.toString(BASIC_ENEMY_REWARD));

            prop.store(output, null);
        } catch (IOException io) {
            throw new RuntimeException(io.getMessage());
        }
    }
}
