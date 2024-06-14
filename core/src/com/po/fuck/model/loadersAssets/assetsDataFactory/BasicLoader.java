package com.po.fuck.model.loadersAssets.assetsDataFactory;

import com.po.fuck.Assets;
import com.po.fuck.model.loadersAssets.BasicSpriteInfo;

public class BasicLoader {
    static {
        Assets.loadClassInfo("enemy", new BasicSpriteInfo("enemy"));
        Assets.loadClassInfo("coin", new BasicSpriteInfo("coin"));
        Assets.loadClassInfo("bullet", new BasicSpriteInfo("bullet"));
        Assets.loadClassInfo("island", new BasicSpriteInfo("island"));
        Assets.loadClassInfo("player", new BasicSpriteInfo("player"));
        Assets.loadClassInfo("laserBeam", new BasicSpriteInfo("laserBeam"));

    }
}
