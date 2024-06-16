package com.po.fuck.AssetsManagment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Assets {

    public static AssetManager manager = new AssetManager();
    public static final JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));
    public static void load() {
        for (JsonValue element : jsonData) {
            manager.load(element.getString("path"), Texture.class);
        }
    }
    public void dispose() {
        manager.dispose();
    }
}
