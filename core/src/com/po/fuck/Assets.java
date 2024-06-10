package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/**
* assetsData.json description
* each .png stores some table of frames for the object
* path - path to texture
* frameWidth - the width of the single frame
* frameHeight - the height of the single frame
* width - the total width of this texture
* height - the total height of this texture
* frameDuration - the time between frames in seconds
* muzzlePositionX/Y - the X/Y coordinate on the frame of the muzzle
* holdingPositionX/Y - the X/Y coordinate on the frame of the holding position (the position of hands)
*/

public class Assets {

    public static AssetManager manager = new AssetManager();

    static final JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));

    public static BasicSpriteInfo getBasicAssetInfo(String name) {
        return new BasicSpriteInfo(name);
    }
    public static WeaponSpriteInfo getWeaponAssetInfo(String name) {
        return new WeaponSpriteInfo(name);
    }

    public static void load() {
        for (JsonValue element : jsonData) {
            manager.load(element.getString("path"), Texture.class);
        }
    }

    public void dispose() {
        manager.dispose();
    }
}
