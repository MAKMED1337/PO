package com.po.fuck.assetsManagement;

public class SpriteLoaders {
    public static SpriteLoader basicSpriteLoader = new SpriteLoader();
    public static WeaponSpriteLoader weaponSpriteLoader = new WeaponSpriteLoader();

    public static void initialize() {
        TextureLoader.preload();
        basicSpriteLoader.initialize();
        weaponSpriteLoader.initialize();
    }
}
