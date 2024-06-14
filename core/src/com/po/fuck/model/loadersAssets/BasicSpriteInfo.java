package com.po.fuck.model.loadersAssets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;

public class BasicSpriteInfo {
    public String path;
    public int frameWidth;
    public int frameHeight;
    public double frameDuration;

    public int width;

    public int height;

    public Vector2 size() {
        return new Vector2(width, height);
    }

    public BasicSpriteInfo(String name) {
        JsonValue jsonValue = Assets.jsonData.get(name);
        width = jsonValue.getInt("width");
        height = jsonValue.getInt("height");
        path = jsonValue.getString("path");
        frameHeight = jsonValue.getInt("frameHeight");
        frameWidth = jsonValue.getInt("frameWidth");
        frameDuration = jsonValue.getDouble("frameDuration");
    }
}
