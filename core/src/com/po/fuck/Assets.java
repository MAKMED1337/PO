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
        return WeaponSpriteInfo.class.cast(spriteData.get(name));
    }

    public static void loadClassInfo(String name, BasicSpriteInfo data) {
        spriteData.put(name, data);
    }

    public void dispose() {
        manager.dispose();
    }
}
