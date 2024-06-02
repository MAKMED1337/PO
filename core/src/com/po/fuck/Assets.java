package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.view.GifDecoder;

public class Assets {

    public AssetManager manager = new AssetManager();
    public static final AssetDescriptor<Texture> glock3Texture =
            new AssetDescriptor<>("glock3.png", Texture.class);
    public static final AssetDescriptor<Texture> glock2Texture =
            new AssetDescriptor<>("glock2.png", Texture.class);
    public static final AssetDescriptor<Texture> basicEnemyTexture =
            new AssetDescriptor<>("basicEnemy.png", Texture.class);
    public static final AssetDescriptor<Texture> bulletTexture =
            new AssetDescriptor<>("bullet2.png", Texture.class);
    public static final AssetDescriptor<Texture> playerTexture =
            new AssetDescriptor<>("FUCKerWithoutHands2.png", Texture.class);
    public static final AssetDescriptor<Texture> laserGunTexture =
            new AssetDescriptor<>("laser_gun2.png", Texture.class);

    public static final AssetDescriptor<Texture> islandTexture =
            new AssetDescriptor<>("island2.png", Texture.class);

    public void load() {
        manager.load(glock3Texture);
        manager.load(basicEnemyTexture);
        manager.load(bulletTexture);
        manager.load(playerTexture);
        manager.load(laserGunTexture);
        manager.load(glock2Texture);
        manager.load(islandTexture);
    }

    public void dispose() {
        manager.dispose();
    }
}
