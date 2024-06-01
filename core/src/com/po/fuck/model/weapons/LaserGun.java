package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class LaserGun extends Gun {
    {
        width = new Sprite(new Texture("laser_gun2.png")).getWidth();
        height = new Sprite(new Texture("laser_gun2.png")).getHeight();
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, direction, owner.getTeamTag());
    }
}
