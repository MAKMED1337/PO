package com.po.fuck.model.AssetsLoader;


import com.po.fuck.AssetsManagement.Assets;
import com.po.fuck.AssetsManagement.BasicSpriteManager;

import com.po.fuck.AssetsManagement.WeaponSpriteManager;
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
        WeaponSpriteManager.storeSpriteData(LaserGun.class, new WeaponSpriteInfo(Assets.jsonData.get("laserGun")));
        WeaponSpriteManager.storeSpriteData(Glock.class, new WeaponSpriteInfo(Assets.jsonData.get("glock")));
    }

    private static void loadBasic() {
        BasicSpriteManager.storeSpriteData(BasicEnemy.class, new BasicSpriteInfo(Assets.jsonData.get("enemy")));
        BasicSpriteManager.storeSpriteData(Coins.class, new BasicSpriteInfo(Assets.jsonData.get("coin")));
        BasicSpriteManager.storeSpriteData(CosmicBullet.class, new BasicSpriteInfo(Assets.jsonData.get("bullet")));
        BasicSpriteManager.storeSpriteData(Room.class, new BasicSpriteInfo(Assets.jsonData.get("island")));
        BasicSpriteManager.storeSpriteData(Player.class, new BasicSpriteInfo(Assets.jsonData.get("player")));
        BasicSpriteManager.storeSpriteData(LaserBeam.class, new BasicSpriteInfo(Assets.jsonData.get("laserBeam")));
    }
    public static void loadAssets() {
        loadWeapons();
        loadBasic();
    }
}
