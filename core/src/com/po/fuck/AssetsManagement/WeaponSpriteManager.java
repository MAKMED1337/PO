package com.po.fuck.AssetsManagement;

import com.po.fuck.model.Sprites.WeaponSpriteInfo;

public class WeaponSpriteManager extends BasicSpriteManager {
    public <T> WeaponSpriteInfo getWeaponSpriteInfo(Class<T> name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }
}
