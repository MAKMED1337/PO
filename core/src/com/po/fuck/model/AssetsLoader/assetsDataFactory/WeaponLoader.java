package com.po.fuck.model.AssetsLoader.assetsDataFactory;

import com.po.fuck.AssetsManagment.SpriteInfo;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserGun;

public class WeaponLoader {
    static {
        SpriteInfo.loadClassInfo(LaserGun.class, new WeaponSpriteInfo("laserGun"));
        SpriteInfo.loadClassInfo(Glock.class, new WeaponSpriteInfo("glock"));
    }
}
