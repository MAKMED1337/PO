package com.po.fuck.assetsManagement;

import com.po.fuck.model.sprites.WeaponSpriteInfo;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserGun;

public class WeaponSpriteLoader extends SpriteLoader {
    @Override
    public <T> WeaponSpriteInfo getSpriteInfo(Class<T> name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }

    @Override
    public void initialize() {
        spriteData.put(LaserGun.class, new WeaponSpriteInfo(TextureLoader.jsonData.get("laserGun")));
        spriteData.put(Glock.class, new WeaponSpriteInfo(TextureLoader.jsonData.get("glock")));
    }
}
