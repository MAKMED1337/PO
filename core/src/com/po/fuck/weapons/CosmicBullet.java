package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class CosmicBullet extends Bullet {
    {
        sprite = new Sprite(new Texture("bullet2.png"));
    }

    CosmicBullet(Vector2 muzzle_position, Vector2 direction) {
        this.position = muzzle_position.cpy().add(direction.cpy().setLength(sprite.getWidth() / 2));
        this.velocity = direction.cpy().setLength(600); // speed
    }
}
