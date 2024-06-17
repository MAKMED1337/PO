package com.po.fuck.model.weapons;

import static com.po.fuck.assetsManagement.SpriteManagers.weaponSpriteManager;
import static com.po.fuck.model.constants.BalanceConstants.LASERGUN_COOLDOWN;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = LASERGUN_COOLDOWN;


        info = weaponSpriteManager.getWeaponSpriteInfo(this.getClass());
        geometryData.setHeight(info.getHeight());
        geometryData.setWidth(info.getWidth());
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new LaserBeam(muzzlePosition, direction, owner.getTeamTag());
    }
}
