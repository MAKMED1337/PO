package com.po.fuck.model.sprites;

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
 *
 * The 3x3 frame grid is numbered as follows:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */

public class BasicSpriteInfo {
    protected final String path;
    protected final Vector2 size;

    protected final double frameDuration;

    public Vector2 getSize() {
        return size.cpy();
    }

    public float getFrameDuration() {
        return (float) frameDuration;
    }

    public String getPath() {
        return path;
    }

    public float getHeight() {
        return size.y;
    }
    public float getWidth() {
        return size.x;
    }

    public BasicSpriteInfo(JsonValue info) {
        path = info.getString("path");
        size = new Vector2(info.getInt("frameWidth"), info.getInt("frameHeight"));
        frameDuration = info.getDouble("frameDuration");
    }
}
