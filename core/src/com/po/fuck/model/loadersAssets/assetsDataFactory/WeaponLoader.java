package com.po.fuck.model.loadersAssets.assetsDataFactory;

import com.po.fuck.Assets;
import com.po.fuck.model.loadersAssets.WeaponSpriteInfo;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserGun;

public class WeaponLoader {
    static {
        Assets.loadClassInfo(LaserGun.class, new WeaponSpriteInfo("laserGun"));
        Assets.loadClassInfo(Glock.class, new WeaponSpriteInfo("glock"));
    }
}
