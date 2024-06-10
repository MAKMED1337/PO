package com.po.fuck;

public class BasicSpriteInfo {
    public String path;
    public int frameWidth;
    public int frameHeight;
    public double frameDuration;

    public int width;

    public int height;

    public BasicSpriteInfo(String name) {
        width = Assets.jsonData.get(name).getInt("width");
        height = Assets.jsonData.get(name).getInt("height");
        path = Assets.jsonData.get(name).getString("path");
        frameHeight = Assets.jsonData.get(name).getInt("frameHeight");
        frameWidth = Assets.jsonData.get(name).getInt("frameWidth");
        frameDuration = Assets.jsonData.get(name).getDouble("frameDuration");
    }
}
