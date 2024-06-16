package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;

import static com.po.fuck.model.Constants.GLOCK_COOLDOWN;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        geometryData.setHeight(Assets.getBasicAssetInfo(this.getClass()).getHeight());
        geometryData.setWidth(Assets.getBasicAssetInfo(this.getClass()).getWidth());
    }
    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
