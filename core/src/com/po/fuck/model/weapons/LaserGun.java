package com.po.fuck.model.weapons;

import static com.po.fuck.assetsManagement.SpriteLoaders.weaponSpriteLoader;
import static com.po.fuck.model.constants.BalanceConstants.LASERGUN_COOLDOWN;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.sprites.WeaponSpriteInfo;

public final class LaserGun extends Gun {
    {
        cooldown = LASERGUN_COOLDOWN;

        setInfo(weaponSpriteLoader.getSpriteInfo(this.getClass()));
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new LaserBeam(muzzlePosition, direction, owner.getTeamTag());
    }
}
