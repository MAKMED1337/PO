package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Assets;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;

public class Glock extends Gun {
    {
        sprite = new Sprite(FUCK.assets.manager.get(Assets.glockTexture));
        cooldown = 0.5f;
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected void shoot(Vector2 muzzle_position, Vector2 direction) {
        new CosmicBullet(muzzle_position, direction);
    }
}
