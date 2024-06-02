package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;


public class Assets {
    private static JsonReader jsonReader = new JsonReader();

    public AssetManager manager = new AssetManager();

    public static JsonValue getInfo(String name) {
        return jsonReader.parse(Gdx.files.internal("assetsData.json")).get(name);
    }

    public void load() {
        JsonReader json = new JsonReader();
        for (JsonValue element : json.parse(Gdx.files.internal("assetsData.json"))) {
            System.out.println(element.getString("path"));
                        manager.load(element.getString("path"), Texture.class);
        }
    }

    public void dispose() {
        manager.dispose();
    }
}
