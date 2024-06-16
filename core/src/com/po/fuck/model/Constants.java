package com.po.fuck.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public final class Constants {
    private static final String GAME_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/game.properties";
    private static final String MOVEMENT_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/movement.properties";
    private static final String PHYSICS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/physics.properties";
    private static final String TAGS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/tags.properties";
    private static final String CAMERA_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/camera.properties";
    private static final String LAYERING_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/layering.properties";
    private static final String BORDERS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/borders.properties";
    private static final String BULLETS_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/bullets.properties";
    private static final String ENEMY_PROPERTIES_PATH = "../core/src/com/po/fuck/model/properties/enemy.properties";

    static Properties loadProperties(String filePath) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(filePath));
            return properties;
        } catch (IOException io) {
            throw new RuntimeException("Unable to load properties file: " + filePath + " - " + io.getMessage());
        }
    }

    static <T> T loadConstant(String name, Class<T> cls, String filePath) {
        Properties properties = loadProperties(filePath);

        String value = properties.getProperty(name);
        if (value == null) {
            throw new RuntimeException(cls.getName() + " " + name + " is not found in " + filePath);
        }
        if (cls == Integer.class) {
            return cls.cast(Integer.valueOf(value));
        } else if (cls == Float.class) {
            return cls.cast(Float.valueOf(value));
        } else {
            throw new IllegalArgumentException("Unsupported property type");
        }
    }

    public static final int SCREEN_WIDTH = loadConstant("SCREEN_WIDTH", Integer.class, GAME_PROPERTIES_PATH);
    public static final int SCREEN_HEIGHT = loadConstant("SCREEN_HEIGHT", Integer.class, GAME_PROPERTIES_PATH);

    /* movement */
    public static final float DEFAULT_SPEED = loadConstant("DEFAULT_SPEED", Float.class, MOVEMENT_PROPERTIES_PATH);
    public static final int BOOST_DISTANCE = loadConstant("BOOST_DISTANCE", Integer.class, MOVEMENT_PROPERTIES_PATH);
    public static final float BOOST_DURATION = loadConstant("BOOST_DURATION", Float.class, MOVEMENT_PROPERTIES_PATH);
    public static final float BOOST_COOLDOWN = loadConstant("BOOST_COOLDOWN", Float.class, MOVEMENT_PROPERTIES_PATH);

    /* physics */
    public static final int COLLISION_ITERATIONS = loadConstant("COLLISION_ITERATIONS", Integer.class, PHYSICS_PROPERTIES_PATH);

    /* team tags */
    public static final int ENEMY_TEAM_TAG = loadConstant("ENEMY_TEAM_TAG", Integer.class, TAGS_PROPERTIES_PATH);
    public static final int PLAYER_TEAM_TAG = loadConstant("PLAYER_TEAM_TAG", Integer.class, TAGS_PROPERTIES_PATH);

    /* camera */
    public static final float CAMERA_SPEED = loadConstant("CAMERA_SPEED", Float.class, CAMERA_PROPERTIES_PATH);

    /* layering */
    public static final int BACKGROUND_LAYER = loadConstant("BACKGROUND_LAYER", Integer.class, LAYERING_PROPERTIES_PATH);
    public static final int ENTITY_LAYER = loadConstant("ENTITY_LAYER", Integer.class, LAYERING_PROPERTIES_PATH);
    public static final int WEAPON_LAYER = loadConstant("WEAPON_LAYER", Integer.class, LAYERING_PROPERTIES_PATH);
    public static final int GUI_LAYER = loadConstant("GUI_LAYER", Integer.class, LAYERING_PROPERTIES_PATH);

    /* borders */
    public static final int GAME_BORDER = loadConstant("GAME_BORDER", Integer.class, BORDERS_PROPERTIES_PATH);

    /* bullets */
    public static final float COSMIC_BULLET_LIFE_TIME = loadConstant("COSMIC_BULLET_LIFE_TIME", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float COSMIC_BULLET_DAMAGE = loadConstant("COSMIC_BULLET_DAMAGE", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float COSMIC_BULLET_SPEED = loadConstant("COSMIC_BULLET_SPEED", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float LASER_BEAM_DAMAGE = loadConstant("LASER_BEAM_DAMAGE", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float LASER_BEAM_LIFE_TIME = loadConstant("LASER_BEAM_LIFE_TIME", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float DEFAULT_BULLET_LIFE_TIME = loadConstant("DEFAULT_BULLET_LIFE_TIME", Float.class, BULLETS_PROPERTIES_PATH);

    public static final float GLOCK_COOLDOWN = loadConstant("GLOCK_COOLDOWN", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float LASERGUN_COOLDOWN = loadConstant("LASERGUN_COOLDOWN", Float.class, BULLETS_PROPERTIES_PATH);

    public static final float PLAYERS_HEALTH = loadConstant("PLAYERS_HEALTH", Float.class, BULLETS_PROPERTIES_PATH);

    public static final float DEFAULT_DISTANCE_FACTOR = loadConstant("DEFAULT_DISTANCE_FACTOR", Float.class, BULLETS_PROPERTIES_PATH);
    public static final float DEFAULT_MAX_DISTANCE_FROM_BODY = loadConstant("DEFAULT_MAX_DISTANCE_FROM_BODY", Float.class, BULLETS_PROPERTIES_PATH);

    public static final float BASIC_ENEMY_SPEED = loadConstant("BASIC_ENEMY_SPEED", Float.class, ENEMY_PROPERTIES_PATH);
    public static final float BASIC_ENEMY_HEALTH = loadConstant("BASIC_ENEMY_HEALTH", Float.class, ENEMY_PROPERTIES_PATH);
    public static final int BASIC_ENEMY_REWARD = loadConstant("BASIC_ENEMY_REWARD", Integer.class, ENEMY_PROPERTIES_PATH);

    public static void saveToProperties() {
        savePropertiesFile(GAME_PROPERTIES_PATH, getGameProperties());
        savePropertiesFile(MOVEMENT_PROPERTIES_PATH, getMovementProperties());
        savePropertiesFile(PHYSICS_PROPERTIES_PATH, getPhysicsProperties());
        savePropertiesFile(TAGS_PROPERTIES_PATH, getTagsProperties());
        savePropertiesFile(CAMERA_PROPERTIES_PATH, getCameraProperties());
        savePropertiesFile(LAYERING_PROPERTIES_PATH, getLayeringProperties());
        savePropertiesFile(BORDERS_PROPERTIES_PATH, getBordersProperties());
        savePropertiesFile(BULLETS_PROPERTIES_PATH, getBulletsProperties());
        savePropertiesFile(ENEMY_PROPERTIES_PATH, getEnemyProperties());
    }

    private static Properties getGameProperties() {
        Properties game = new Properties();
        game.setProperty("SCREEN_WIDTH", Integer.toString(SCREEN_WIDTH));
        game.setProperty("SCREEN_HEIGHT", Integer.toString(SCREEN_HEIGHT));
        return game;
    }

    private static Properties getMovementProperties() {
        Properties movement = new Properties();
        movement.setProperty("DEFAULT_SPEED", Float.toString(DEFAULT_SPEED));
        movement.setProperty("BOOST_DISTANCE", Integer.toString(BOOST_DISTANCE));
        movement.setProperty("BOOST_DURATION", Float.toString(BOOST_DURATION));
        movement.setProperty("BOOST_COOLDOWN", Float.toString(BOOST_COOLDOWN));
        return movement;
    }

    private static Properties getPhysicsProperties() {
        Properties physics = new Properties();
        physics.setProperty("COLLISION_ITERATIONS", Integer.toString(COLLISION_ITERATIONS));
        return physics;
    }

    private static Properties getTagsProperties() {
        Properties tags = new Properties();
        tags.setProperty("ENEMY_TEAM_TAG", Integer.toString(ENEMY_TEAM_TAG));
        tags.setProperty("PLAYER_TEAM_TAG", Integer.toString(PLAYER_TEAM_TAG));
        return tags;
    }

    private static Properties getCameraProperties() {
        Properties camera = new Properties();
        camera.setProperty("CAMERA_SPEED", Float.toString(CAMERA_SPEED));
        return camera;
    }

    private static Properties getLayeringProperties() {
        Properties layering = new Properties();
        layering.setProperty("BACKGROUND_LAYER", Integer.toString(BACKGROUND_LAYER));
        layering.setProperty("ENTITY_LAYER", Integer.toString(ENTITY_LAYER));
        layering.setProperty("WEAPON_LAYER", Integer.toString(WEAPON_LAYER));
        layering.setProperty("GUI_LAYER", Integer.toString(GUI_LAYER));
        return layering;
    }

    private static Properties getBordersProperties() {
        Properties borders = new Properties();
        borders.setProperty("GAME_BORDER", Integer.toString(GAME_BORDER));
        return borders;
    }

    private static Properties getBulletsProperties() {
        Properties bullets = new Properties();
        bullets.setProperty("COSMIC_BULLET_LIFE_TIME", Float.toString(COSMIC_BULLET_LIFE_TIME));
        bullets.setProperty("COSMIC_BULLET_DAMAGE", Float.toString(COSMIC_BULLET_DAMAGE));
        bullets.setProperty("COSMIC_BULLET_SPEED", Float.toString(COSMIC_BULLET_SPEED));
        bullets.setProperty("LASER_BEAM_DAMAGE", Float.toString(LASER_BEAM_DAMAGE));
        bullets.setProperty("LASER_BEAM_LIFE_TIME", Float.toString(LASER_BEAM_LIFE_TIME));
        bullets.setProperty("DEFAULT_BULLET_LIFE_TIME", Float.toString(DEFAULT_BULLET_LIFE_TIME));
        bullets.setProperty("GLOCK_COOLDOWN", Float.toString(GLOCK_COOLDOWN));
        bullets.setProperty("LASERGUN_COOLDOWN", Float.toString(LASERGUN_COOLDOWN));
        bullets.setProperty("PLAYERS_HEALTH", Float.toString(PLAYERS_HEALTH));
        bullets.setProperty("DEFAULT_DISTANCE_FACTOR", Float.toString(DEFAULT_DISTANCE_FACTOR));
        bullets.setProperty("DEFAULT_MAX_DISTANCE_FROM_BODY", Float.toString(DEFAULT_MAX_DISTANCE_FROM_BODY));
        return bullets;
    }

    private static Properties getEnemyProperties() {
        Properties enemy = new Properties();
        enemy.setProperty("BASIC_ENEMY_SPEED", Float.toString(BASIC_ENEMY_SPEED));
        enemy.setProperty("BASIC_ENEMY_HEALTH", Float.toString(BASIC_ENEMY_HEALTH));
        enemy.setProperty("BASIC_ENEMY_REWARD", Integer.toString(BASIC_ENEMY_REWARD));
        return enemy;
    }

    private static void savePropertiesFile(String filePath, Properties properties) {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to properties file: " + filePath + " - " + e.getMessage());
        }
    }
}
