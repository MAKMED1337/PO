package com.po.fuck.model.weapons;


import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;

public final class Glock extends Gun {
    {
        cooldown = 0.5f;
    }

    public Glock(Entity owner) {
        super(owner);
        name = "glock";

        geometryData.setHeight(Assets.getAssetInfo(name).height);
        geometryData.setWidth(Assets.getAssetInfo(name).width);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new CosmicBullet(muzzle_position, Assets.getAssetInfo(name).width,
                                                Assets.getAssetInfo(name).height,
                                                direction, owner.getTeamTag());
    }
}
