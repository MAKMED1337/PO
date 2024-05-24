package com.po.fuck;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public AssetManager manager = new AssetManager();
    public static final AssetDescriptor<Texture> glockTexture =
            new AssetDescriptor<>("glock3.png", Texture.class);
    public static final AssetDescriptor<Texture> basicEnemyTexture =
            new AssetDescriptor<>("basicEnemy.png", Texture.class);
    public static final AssetDescriptor<Texture> bulletTexture =
            new AssetDescriptor<>("bullet2.png", Texture.class);
    public static final AssetDescriptor<Texture> playerTexture =
            new AssetDescriptor<>("FUCKerWithoutHands2.png", Texture.class);
    public static final AssetDescriptor<Texture> laserGunTexture =
            new AssetDescriptor<>("laser_gun2.png", Texture.class);
    public void load() {
        manager.load(glockTexture);
        manager.load(basicEnemyTexture);
        manager.load(bulletTexture);
        manager.load(playerTexture);
        manager.load(laserGunTexture);
    }

    public void dispose() {
        manager.dispose();
    }
}
