package com.po.fuck.AssetsManagement;


import com.po.fuck.model.Coins;
import com.po.fuck.model.Player;
import com.po.fuck.model.Room;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.model.weapons.LaserGun;
import com.po.fuck.model.Sprites.BasicSpriteInfo;
import com.po.fuck.model.Sprites.WeaponSpriteInfo;

import static com.po.fuck.AssetsManagement.SpriteManagers.basicSpriteManager;
import static com.po.fuck.AssetsManagement.SpriteManagers.weaponSpriteManager;


public class AssetsDataLoader {

    private static void preloadWeaponsData() {
        weaponSpriteManager.storeSpriteData(LaserGun.class, new WeaponSpriteInfo(TextureLoader.jsonData.get("laserGun")));
        weaponSpriteManager.storeSpriteData(Glock.class, new WeaponSpriteInfo(TextureLoader.jsonData.get("glock")));
    }

    private static void preloadBasicData() {
        basicSpriteManager.storeSpriteData(BasicEnemy.class, new BasicSpriteInfo(TextureLoader.jsonData.get("enemy")));
        basicSpriteManager.storeSpriteData(Coins.class, new BasicSpriteInfo(TextureLoader.jsonData.get("coin")));
        basicSpriteManager.storeSpriteData(CosmicBullet.class, new BasicSpriteInfo(TextureLoader.jsonData.get("bullet")));
        basicSpriteManager.storeSpriteData(Room.class, new BasicSpriteInfo(TextureLoader.jsonData.get("island")));
        basicSpriteManager.storeSpriteData(Player.class, new BasicSpriteInfo(TextureLoader.jsonData.get("player")));
        basicSpriteManager.storeSpriteData(LaserBeam.class, new BasicSpriteInfo(TextureLoader.jsonData.get("laserBeam")));
    }
    public static void preloadAssets() {
        preloadWeaponsData();
        preloadBasicData();
    }
}
