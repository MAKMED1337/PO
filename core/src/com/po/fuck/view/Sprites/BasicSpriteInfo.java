package com.po.fuck.view.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.AssetsManagment.Assets;

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
    public int frameWidth;
    public int frameHeight;
    public double frameDuration;


    Vector2 size;
    public Vector2 size() {
        return size.cpy();
    }

    public float getHeight() {
        return size.x;
    }

    public float getWidth() {
        return size.y;
    }

    public BasicSpriteInfo(String name) {
        JsonValue jsonValue = Assets.jsonData.get(name);
        size = new Vector2(jsonValue.getInt("height"), jsonValue.getInt("width"));
        path = jsonValue.getString("path");
        frameHeight = jsonValue.getInt("frameHeight");
        frameWidth = jsonValue.getInt("frameWidth");
        frameDuration = jsonValue.getDouble("frameDuration");
    }
}
