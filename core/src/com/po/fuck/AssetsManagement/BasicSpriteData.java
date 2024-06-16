package com.po.fuck.AssetsManagement;

import com.po.fuck.view.Sprites.BasicSpriteInfo;

import java.util.HashMap;
import java.util.Map;

public class BasicSpriteData {

    static Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();

    public static <T> BasicSpriteInfo getBasicSpriteInfo(Class<T> cls) {
        return spriteData.get(cls);
    }

    public static<T> void storeSpriteData(Class<T> clz, BasicSpriteInfo data) {
        spriteData.put(clz, data);
    }
}
