package com.po.fuck.model.loadersAssets.assetsDataFactory;

import com.po.fuck.Assets;
import com.po.fuck.model.Coins;
import com.po.fuck.model.Player;
import com.po.fuck.model.Room;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.loadersAssets.BasicSpriteInfo;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.LaserBeam;

public class BasicLoader {
    static {
        Assets.loadClassInfo(BasicEnemy.class, new BasicSpriteInfo("enemy"));
        Assets.loadClassInfo(Coins.class, new BasicSpriteInfo("coin"));
        Assets.loadClassInfo(CosmicBullet.class, new BasicSpriteInfo("bullet"));
        Assets.loadClassInfo(Room.class, new BasicSpriteInfo("island"));
        Assets.loadClassInfo(Player.class, new BasicSpriteInfo("player"));
        Assets.loadClassInfo(LaserBeam.class, new BasicSpriteInfo("laserBeam"));

    }
}
