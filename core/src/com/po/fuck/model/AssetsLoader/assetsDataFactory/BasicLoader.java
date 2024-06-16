package com.po.fuck.model.AssetsLoader.assetsDataFactory;

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
        SpriteInfo.loadClassInfo(BasicEnemy.class, new BasicSpriteInfo("enemy"));
        SpriteInfo.loadClassInfo(Coins.class, new BasicSpriteInfo("coin"));
        SpriteInfo.loadClassInfo(CosmicBullet.class, new BasicSpriteInfo("bullet"));
        SpriteInfo.loadClassInfo(Room.class, new BasicSpriteInfo("island"));
        SpriteInfo.loadClassInfo(Player.class, new BasicSpriteInfo("player"));
        SpriteInfo.loadClassInfo(LaserBeam.class, new BasicSpriteInfo("laserBeam"));

    }
}
