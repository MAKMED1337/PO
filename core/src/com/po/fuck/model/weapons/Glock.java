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

        geometryData.setHeight(Assets.getBasicAssetInfo(name).height);
        geometryData.setWidth(Assets.getBasicAssetInfo(name).width);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new CosmicBullet(muzzle_position, Assets.getBasicAssetInfo(name).width,
                                                Assets.getBasicAssetInfo(name).height,
                                                direction, owner.getTeamTag());
    }
}
