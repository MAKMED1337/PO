package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;

public class Glock extends Gun {
    {
        sprite = new Sprite(new Texture("glock3.png"));
        cooldown = 0.5f;
    }

    public Glock(Entity owner) {
        super(owner);
        teamTag = owner.teamTag;
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new CosmicBullet(muzzle_position, direction, owner.teamTag);
    }
}
