package com.po.fuck.model.Loaders.Loaders;

import com.po.fuck.Assets;
import com.po.fuck.model.Loaders.WeaponSpriteInfo;

public class WeaponLoader {
    static {
        Assets.loadClassInfo("laserGun", new WeaponSpriteInfo("laserGun"));
        Assets.loadClassInfo("glock", new WeaponSpriteInfo("glock"));
    }
}
