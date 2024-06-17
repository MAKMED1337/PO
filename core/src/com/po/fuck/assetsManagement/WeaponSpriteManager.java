package com.po.fuck.assetsManagement;

import com.po.fuck.model.sprites.WeaponSpriteInfo;

public class WeaponSpriteManager extends BasicSpriteManager {
    public <T> WeaponSpriteInfo getWeaponSpriteInfo(Class<T> name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }
}
