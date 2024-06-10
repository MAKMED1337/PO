package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Assets;
import com.po.fuck.WeaponSpriteInfo;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
        name = "laserGun";

        WeaponSpriteInfo info = (WeaponSpriteInfo) Assets.getAssetInfo(name);
        geometryData.setHeight(info.height);
        geometryData.setWidth(info.width);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, Assets.getAssetInfo("laserBeam").frameWidth,
                Assets.getAssetInfo("laserBeam").frameHeight, direction, owner.getTeamTag());
    }
}
