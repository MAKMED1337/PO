package com.po.fuck.assetsManagement;

import com.po.fuck.model.Coins;
import com.po.fuck.model.Player;
import com.po.fuck.model.Room;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.sprites.BasicSpriteInfo;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.LaserBeam;

import java.util.HashMap;
import java.util.Map;



public class SpriteLoader {

    Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();

    public void initialize() {
        spriteData.put(BasicEnemy.class, new BasicSpriteInfo(TextureLoader.jsonData.get("enemy")));
        spriteData.put(Coins.class, new BasicSpriteInfo(TextureLoader.jsonData.get("coin")));
        spriteData.put(CosmicBullet.class, new BasicSpriteInfo(TextureLoader.jsonData.get("bullet")));
        spriteData.put(Room.class, new BasicSpriteInfo(TextureLoader.jsonData.get("island")));
        spriteData.put(Player.class, new BasicSpriteInfo(TextureLoader.jsonData.get("player")));
        spriteData.put(LaserBeam.class, new BasicSpriteInfo(TextureLoader.jsonData.get("laserBeam")));
    }

    public <T> BasicSpriteInfo getSpriteInfo(Class<T> cls) {
        return spriteData.get(cls);
    }

    public <T> void storeSpriteData(Class<T> clz, BasicSpriteInfo data) {
        spriteData.put(clz, data);
    }
}
