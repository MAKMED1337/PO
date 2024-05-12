package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Player;

public class Glock extends Gun {
    {
        sprite = new Sprite(new Texture("glock3.png"));
        cooldown = 0.3f;
    }

    public Glock(Player owner) {
        super(owner);
    }

    @Override
    protected void shoot(Vector2 muzzle_position, Vector2 direction) {
        new CosmicBullet(muzzle_position, direction);
    }
}
