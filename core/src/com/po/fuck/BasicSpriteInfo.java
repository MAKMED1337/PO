package com.po.fuck;

public class BasicSpriteInfo {
    public int width;

    public int height;
    public String path;
    public int frameHeight;
    public int frameWidth;
    public double frameDuration;

    public BasicSpriteInfo(String name) {
        width = Assets.jsonData.get(name).getInt("width");
        height = Assets.jsonData.get(name).getInt("height");
        path = Assets.jsonData.get(name).getString("path");
        frameHeight = Assets.jsonData.get(name).getInt("frameHeight");
        frameWidth = Assets.jsonData.get(name).getInt("frameWidth");
        frameDuration = Assets.jsonData.get(name).getDouble("frameDuration");
    }
}
