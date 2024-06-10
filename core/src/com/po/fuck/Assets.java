package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class Assets {

    public static AssetManager manager = new AssetManager();

    private static final String[] basicAssetsNames = new String[]{"laserBeam", "player", "island",
            "coin", "bullet", "enemy"};
    private static final String[] weaponAssetsNames = new String[]{"glock", "laserGun"};

    public static Map<String, BasicSpriteInfo> information = new HashMap<>();

    static final JsonValue jsonData = (new JsonReader()).parse(Gdx.files.internal("assetsData.json"));

    public static BasicSpriteInfo getAssetInfo(String name) {
        return information.get(name);
    }

    public static void load() {
        JsonReader json = new JsonReader();
        for (JsonValue element : json.parse(Gdx.files.internal("assetsData.json")))
            manager.load(element.getString("path"), Texture.class);

        for (String name : basicAssetsNames)
            information.put(name, new BasicSpriteInfo(name));
        for (String name : weaponAssetsNames)
            information.put(name, new WeaponSpriteInfo(name));
    }

    public void dispose() {
        manager.dispose();
    }
}
