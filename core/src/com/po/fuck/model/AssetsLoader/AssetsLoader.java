package com.po.fuck.model.AssetsLoader;


import com.po.fuck.AssetsManagement.Assets;
import com.po.fuck.AssetsManagement.SpriteInfoManager;

import com.po.fuck.model.Coins;
import com.po.fuck.model.Player;
import com.po.fuck.model.Room;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.model.weapons.LaserGun;
import com.po.fuck.view.Sprites.BasicSpriteInfo;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;


public class AssetsLoader {

    private static void loadWeapons() {
        SpriteInfoManager.storeSpriteData(LaserGun.class, new WeaponSpriteInfo(Assets.jsonData.get("laserGun")));
        SpriteInfoManager.storeSpriteData(Glock.class, new WeaponSpriteInfo(Assets.jsonData.get("glock")));
    }

    private static void loadBasic() {
        SpriteInfoManager.storeSpriteData(BasicEnemy.class, new BasicSpriteInfo(Assets.jsonData.get("enemy")));
        SpriteInfoManager.storeSpriteData(Coins.class, new BasicSpriteInfo(Assets.jsonData.get("coin")));
        SpriteInfoManager.storeSpriteData(CosmicBullet.class, new BasicSpriteInfo(Assets.jsonData.get("bullet")));
        SpriteInfoManager.storeSpriteData(Room.class, new BasicSpriteInfo(Assets.jsonData.get("island")));
        SpriteInfoManager.storeSpriteData(Player.class, new BasicSpriteInfo(Assets.jsonData.get("player")));
        SpriteInfoManager.storeSpriteData(LaserBeam.class, new BasicSpriteInfo(Assets.jsonData.get("laserBeam")));
    }
    public static void loadAssets() {
        loadWeapons();
        loadBasic();
    }
}
