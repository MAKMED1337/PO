package com.po.fuck.view.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

/*
 * assetsData.json description
 * all textures have:
 * each .png stores some table of frames for the object
 * path - path to texture
 * width - the frame width
 * height - the frame height
 * frameDuration - the time between frames in seconds
 */

public class BasicSpriteInfo {
    public String path;
    public Vector2 size;

    public double frameDuration;

    public Vector2 getFrameSize() {
        return size.cpy();
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
