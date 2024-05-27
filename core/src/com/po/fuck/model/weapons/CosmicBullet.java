package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class CosmicBullet extends Bullet {
    {
        sprite = new Sprite(new Texture("bullet2.png"));
        damage = 1;
    }

    CosmicBullet(Vector2 muzzle_position, Vector2 direction, int teamTag) {
        this.teamTag = teamTag;
        this.position = muzzle_position.cpy().add(direction.cpy().setLength(sprite.getWidth() / 2));
        this.velocity = direction.cpy().setLength(600); // speed
    }
}
