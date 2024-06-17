package com.po.fuck.model.weapons;

import static com.po.fuck.assetsManagement.SpriteLoaders.weaponSpriteLoader;
import static com.po.fuck.model.constants.BalanceConstants.GLOCK_COOLDOWN;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.sprites.WeaponSpriteInfo;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        setInfo(weaponSpriteLoader.getSpriteInfo(this.getClass()));
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
