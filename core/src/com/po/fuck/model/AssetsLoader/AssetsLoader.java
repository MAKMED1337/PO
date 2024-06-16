package com.po.fuck.model.AssetsLoader;


import com.po.fuck.AssetsManagement.Assets;
import com.po.fuck.AssetsManagement.SpriteInfo;

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
        SpriteInfo.storeSpriteData(LaserGun.class, new WeaponSpriteInfo(Assets.jsonData.get("laserGun")));
        SpriteInfo.storeSpriteData(Glock.class, new WeaponSpriteInfo(Assets.jsonData.get("glock")));
    }

    private static void loadBasic() {
        SpriteInfo.storeSpriteData(BasicEnemy.class, new BasicSpriteInfo(Assets.jsonData.get("enemy")));
        SpriteInfo.storeSpriteData(Coins.class, new BasicSpriteInfo(Assets.jsonData.get("coin")));
        SpriteInfo.storeSpriteData(CosmicBullet.class, new BasicSpriteInfo(Assets.jsonData.get("bullet")));
        SpriteInfo.storeSpriteData(Room.class, new BasicSpriteInfo(Assets.jsonData.get("island")));
        SpriteInfo.storeSpriteData(Player.class, new BasicSpriteInfo(Assets.jsonData.get("player")));
        SpriteInfo.storeSpriteData(LaserBeam.class, new BasicSpriteInfo(Assets.jsonData.get("laserBeam")));
    }
    public static void loadAssets() {
        loadWeapons();
        loadBasic();
    }
}
