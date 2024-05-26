package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;

public final class LaserGun extends Gun {
    {
        sprite = new Sprite(new Texture("laser_gun2.png"));
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, direction, owner.teamTag);
    }
}
