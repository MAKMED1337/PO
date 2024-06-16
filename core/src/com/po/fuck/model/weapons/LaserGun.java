package com.po.fuck.model.weapons;

import static com.po.fuck.model.Constants.LASERGUN_COOLDOWN;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.AssetsManagement.WeaponSpriteManager;
import com.po.fuck.view.Sprites.WeaponSpriteInfo;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = LASERGUN_COOLDOWN;


        WeaponSpriteInfo info = WeaponSpriteManager.getWeaponSpriteInfo(this.getClass());
        geometryData.setHeight(info.getFrameHeight());
        geometryData.setWidth(info.getFrameWidth());
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new LaserBeam(muzzlePosition, direction, owner.getTeamTag());
    }
}
