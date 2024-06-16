package com.po.fuck.model.AssetsLoader.assetsDataFactory;

import com.po.fuck.AssetsManagment.Assets;
import com.po.fuck.model.Coins;
import com.po.fuck.model.Player;
import com.po.fuck.model.Room;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.view.Sprites.BasicSpriteInfo;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.AssetsManagment.SpriteInfo;

public class BasicLoader {
    static {
        SpriteInfo.loadClassInfo(BasicEnemy.class, new BasicSpriteInfo(Assets.jsonData.get("enemy")));
        SpriteInfo.loadClassInfo(Coins.class, new BasicSpriteInfo(Assets.jsonData.get("coin")));
        SpriteInfo.loadClassInfo(CosmicBullet.class, new BasicSpriteInfo(Assets.jsonData.get("bullet")));
        SpriteInfo.loadClassInfo(Room.class, new BasicSpriteInfo(Assets.jsonData.get("island")));
        SpriteInfo.loadClassInfo(Player.class, new BasicSpriteInfo(Assets.jsonData.get("player")));
        SpriteInfo.loadClassInfo(LaserBeam.class, new BasicSpriteInfo(Assets.jsonData.get("laserBeam")));
    }
}
