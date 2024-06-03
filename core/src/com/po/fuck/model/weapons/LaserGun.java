package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
        name = "laserGun";

        JsonValue info = Assets.getInfo(name);
        geometryData.setHeight(info.getInt("height"));
        geometryData.setWidth(info.getInt("width"));
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, Assets.getInfo("laserBeam").getInt("frameWidth"),
                Assets.getInfo("laserBeam").getInt("frameHeight"), direction, owner.getTeamTag());
    }
}
