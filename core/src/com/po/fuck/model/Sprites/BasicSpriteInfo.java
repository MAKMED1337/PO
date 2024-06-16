package com.po.fuck.model.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

/*
 * assetsData.json description
 * all textures have:
 * each .png stores some table of frames for the object
 * path - path to the texture
 * width - the frame width
 * height - the frame height
 * frameDuration - the time between frames in seconds
 */

public class BasicSpriteInfo {
    private final String path;
    private final Vector2 size;

    private final double frameDuration;

    public Vector2 getSize() {
        return size.cpy();
    }

    public float getFrameDur() {
        return (float) frameDuration;
    }

    public String getPath() {
        return path;
    }

    public float getHeight() {
        return size.x;
    }
    public float getWidth() {
        return size.y;
    }

    public BasicSpriteInfo(JsonValue info) {
        path = info.getString("path");
        size = new Vector2(info.getInt("frameHeight"), info.getInt("frameWidth"));
        frameDuration = info.getDouble("frameDuration");
    }
}
