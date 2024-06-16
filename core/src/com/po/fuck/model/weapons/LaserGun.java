package com.po.fuck.model.weapons;

import static com.po.fuck.model.constants.BalanceConstants.LASERGUN_COOLDOWN;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        cooldown = LASERGUN_COOLDOWN;
        geometryData.setHeight(new Sprite(new Texture("laser_gun2.png")).getHeight());
        geometryData.setWidth(new Sprite(new Texture("laser_gun2.png")).getWidth());
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new LaserBeam(muzzlePosition, direction, owner.getTeamTag());
    }
}
