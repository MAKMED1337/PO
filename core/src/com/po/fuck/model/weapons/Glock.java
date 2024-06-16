package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.AssetsManagement.WeaponSpriteManager;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Sprites.WeaponSpriteInfo;

import static com.po.fuck.model.Constants.GLOCK_COOLDOWN;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        WeaponSpriteInfo info = WeaponSpriteManager.getWeaponSpriteInfo(this.getClass());
        geometryData.setHeight(info.getHeight());
        geometryData.setWidth(info.getWidth());
    }
    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
