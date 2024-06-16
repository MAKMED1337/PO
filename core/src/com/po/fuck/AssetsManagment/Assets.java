package com.po.fuck.AssetsManagment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.view.Sprites.BasicSpriteInfo;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;

import java.util.HashMap;
import java.util.Map;


public class Assets {

    public static AssetManager manager = new AssetManager();
    public static final JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));
    public static void load() {
        JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));
        for (JsonValue element : jsonData) {
            manager.load(element.getString("path"), Texture.class);
        }
    }
//    static Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();
//
//    public static <T> BasicSpriteInfo getBasicAssetInfo(Class<T> cls) {
//        return spriteData.get(cls);
//    }
//
//    public static<T> WeaponSpriteInfo getWeaponAssetInfo(Class<T> name) {
//        return (WeaponSpriteInfo) spriteData.get(name);
//    }
//
//    public static<T> void loadClassInfo(Class<T> clz, BasicSpriteInfo data) {
//        spriteData.put(clz, data);
//    }
    public void dispose() {
        manager.dispose();
    }
}
