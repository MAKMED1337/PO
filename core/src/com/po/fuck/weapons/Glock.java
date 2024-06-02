package com.po.fuck.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.po.fuck.Assets;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;

public class Glock extends Gun {
    {
        sprite = new Sprite(FUCK.assets.manager.get(Assets.glock2Texture));
        cooldown = 0.5f;
        muzzleShift = 15;
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected void shoot(Vector2 muzzle_position, Vector2 direction) {
        new CosmicBullet(muzzle_position, direction);
    }
}
