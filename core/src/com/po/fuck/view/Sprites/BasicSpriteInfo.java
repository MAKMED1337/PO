package com.po.fuck.view.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

/*
 * assetsData.json description
 * all textures have:
 * each .png stores some table of frames for the object
 * path - path to texture
 * frameWidth - the width of single frame
 * frameHeight - the height of single frame
 * width - the total width of this texture
 * height - the total height of this texture
 * frameDuration - the time between frames in seconds
 */

public class BasicSpriteInfo {
    public String path;
    public Vector2 frameSize;

    public double frameDuration;

    private Vector2 size;
    public Vector2 size() {
        return size.cpy();
    }

    public float getHeight() {
        return size.x;
    }

    public float getWidth() {
        return size.y;
    }

    public Vector2 getFrameSize() {
        return frameSize.cpy();
    }

    public float getFrameHeight() {
        return frameSize.x;
    }
    public float getFrameWidth() {
        return frameSize.y;
    }

    public BasicSpriteInfo(JsonValue info) {
        size = new Vector2(info.getInt("height"), info.getInt("width"));
        path = info.getString("path");
        frameSize = new Vector2(info.getInt("frameHeight"), info.getInt("frameWidth"));
        frameDuration = info.getDouble("frameDuration");
    }
}
