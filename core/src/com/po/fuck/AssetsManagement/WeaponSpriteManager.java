package com.po.fuck.AssetsManagement;


import com.po.fuck.view.Sprites.WeaponSpriteInfo;

import java.util.HashMap;
import java.util.Map;

public class WeaponSpriteManager {

    static Map<Class<?>, WeaponSpriteInfo> spriteData = new HashMap<>();

    public static<T> WeaponSpriteInfo getWeaponSpriteInfo(Class<T> name) {
        return spriteData.get(name);
    }

    public static<T> void storeSpriteData(Class<T> clz, WeaponSpriteInfo data) {
        spriteData.put(clz, data);
    }
}
