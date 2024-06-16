package com.po.fuck.AssetsManagment;

import com.po.fuck.view.Sprites.BasicSpriteInfo;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;

import java.util.HashMap;
import java.util.Map;

public class SpriteInfo {
    static Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();

    public static <T> BasicSpriteInfo getBasicAssetInfo(Class<T> cls) {
        return spriteData.get(cls);
    }

    public static<T> WeaponSpriteInfo getWeaponAssetInfo(Class<T> name) {
        return (WeaponSpriteInfo) spriteData.get(name);
    }

    public static<T> void loadClassInfo(Class<T> clz, BasicSpriteInfo data) {
        spriteData.put(clz, data);
    }

}
