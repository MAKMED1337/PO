package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.model.loadersAssets.BasicSpriteInfo;
import com.po.fuck.model.loadersAssets.WeaponSpriteInfo;

import java.util.HashMap;
import java.util.Map;

/**
* assetsData.json description
* all textures have:
* each .png stores some table of frames for the object
* path - path to texture
* frameWidth - the width of single frame
* frameHeight - the height of single frame
* width - the total width of this texture
* height - the total height of this texture
* frameDuration - the time between frames in seconds
* Only weapons have:
* muzzlePositionX/Y - the X/Y coordinate on the frame of the muzzle
* holdingPositionX/Y - the X/Y coordinate on the frame of the holding position (the position of hands)
*/

public class Assets {

    public static AssetManager manager = new AssetManager();

    public static final JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));

    public static void load() {
        for (JsonValue element : jsonData) {
            manager.load(element.getString("path"), Texture.class);
        }
    }

    static Map<String, BasicSpriteInfo> spriteData = new HashMap<>();

    public static BasicSpriteInfo getBasicAssetInfo(String name) {
        return spriteData.get(name);
    }

    public static WeaponSpriteInfo getWeaponAssetInfo(String name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }

    public static void loadClassInfo(String name, BasicSpriteInfo data) {
        spriteData.put(name, data);
    }

    public void dispose() {
        manager.dispose();
    }
}
