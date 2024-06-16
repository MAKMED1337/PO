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


public class AssetsDataLoader {

    private static void preloadWeaponsData() {
        WeaponSpriteManager.storeSpriteData(LaserGun.class, new WeaponSpriteInfo(AssetsTextureLoader.jsonData.get("laserGun")));
        WeaponSpriteManager.storeSpriteData(Glock.class, new WeaponSpriteInfo(AssetsTextureLoader.jsonData.get("glock")));
    }

    private static void preloadBasicData() {
        BasicSpriteManager.storeSpriteData(BasicEnemy.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("enemy")));
        BasicSpriteManager.storeSpriteData(Coins.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("coin")));
        BasicSpriteManager.storeSpriteData(CosmicBullet.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("bullet")));
        BasicSpriteManager.storeSpriteData(Room.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("island")));
        BasicSpriteManager.storeSpriteData(Player.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("player")));
        BasicSpriteManager.storeSpriteData(LaserBeam.class, new BasicSpriteInfo(AssetsTextureLoader.jsonData.get("laserBeam")));
    }
    public static void loadAssets() {
        preloadWeaponsData();
        preloadBasicData();
    }
}
