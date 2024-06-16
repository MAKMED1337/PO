package com.po.fuck.AssetsManagement;

import com.po.fuck.view.Sprites.BasicSpriteInfo;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;

import java.util.HashMap;
import java.util.Map;

public class SpriteInfoManager {
    static Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();

    public static <T> BasicSpriteInfo getBasicSpriteInfo(Class<T> cls) {
        return spriteData.get(cls);
    }

    public static<T> WeaponSpriteInfo getWeaponSpriteInfo(Class<T> name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }

    public static<T> void storeSpriteData(Class<T> clz, BasicSpriteInfo data) {
        spriteData.put(clz, data);
    }

}
