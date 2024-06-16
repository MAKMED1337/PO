package com.po.fuck.model.constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public final class ConstantsSaver {
    public static void saveToProperties() {
        savePropertiesFile(GameConstants.GAME_PROPERTIES_PATH, GameConstants.getProperties());
        savePropertiesFile(MovementConstants.MOVEMENT_PROPERTIES_PATH, MovementConstants.getProperties());
        savePropertiesFile(PhysicsConstants.PHYSICS_PROPERTIES_PATH, PhysicsConstants.getProperties());
        savePropertiesFile(TagsConstants.TAGS_PROPERTIES_PATH, TagsConstants.getProperties());
        savePropertiesFile(CameraConstants.CAMERA_PROPERTIES_PATH, CameraConstants.getProperties());
        savePropertiesFile(LayeringConstants.LAYERING_PROPERTIES_PATH, LayeringConstants.getProperties());
        savePropertiesFile(BordersConstants.BORDERS_PROPERTIES_PATH, BordersConstants.getProperties());
        savePropertiesFile(BulletsConstants.BULLETS_PROPERTIES_PATH, BulletsConstants.getProperties());
        savePropertiesFile(BalanceConstants.BALANCE_PROPERTIES_PATH, BalanceConstants.getProperties());
    }

    protected static void savePropertiesFile(String filePath, Properties properties) {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to properties file: " + filePath + " - " + e.getMessage());
        }
    }
}
