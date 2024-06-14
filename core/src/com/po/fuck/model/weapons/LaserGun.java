package com.po.fuck.model.weapons;

import static com.po.fuck.model.Constants.LASERGUN_COOLDOWN;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Assets;
import com.po.fuck.model.Loaders.WeaponSpriteInfo;
import com.po.fuck.model.Loaders.AssetsLoader;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = LASERGUN_COOLDOWN;
    }

    public LaserGun(Entity owner) {
        super(owner);
        name = "laserGun";

        WeaponSpriteInfo info = Assets.getWeaponAssetInfo(name);
        geometryData.setHeight(info.height);
        geometryData.setWidth(info.width);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new LaserBeam(muzzlePosition, direction, owner.getTeamTag());
    }
}
