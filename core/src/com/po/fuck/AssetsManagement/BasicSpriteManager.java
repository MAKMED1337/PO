package com.po.fuck.AssetsManagement;

import com.po.fuck.model.Sprites.BasicSpriteInfo;

import java.util.HashMap;
import java.util.Map;

public class BasicSpriteManager {

    Map<Class<?>, BasicSpriteInfo> spriteData = new HashMap<>();

    public <T> BasicSpriteInfo getBasicSpriteInfo(Class<T> cls) {
        return spriteData.get(cls);
    }

    public <T> void storeSpriteData(Class<T> clz, BasicSpriteInfo data) {
        spriteData.put(clz, data);
    }
}
