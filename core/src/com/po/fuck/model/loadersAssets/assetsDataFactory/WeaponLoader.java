package com.po.fuck.model.loadersAssets.assetsDataFactory;

import com.po.fuck.Assets;
import com.po.fuck.model.loadersAssets.WeaponSpriteInfo;

public class WeaponLoader {
    static {
        Assets.loadClassInfo("laserGun", new WeaponSpriteInfo("laserGun"));
        Assets.loadClassInfo("glock", new WeaponSpriteInfo("glock"));
    }
}
