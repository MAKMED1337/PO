package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import static com.po.fuck.model.Constants.COSMIC_BULLET_DAMAGE;
import static com.po.fuck.model.Constants.COSMIC_BULLET_LIFE_TIME;

public final class CosmicBullet extends Bullet {
    {
        damage = COSMIC_BULLET_DAMAGE;
        lifeTime = COSMIC_BULLET_LIFE_TIME;
        /* Temp solution, afterwards use AssetManager or .properties later */
        width = new Sprite(new Texture("bullet2.png")).getWidth();
        height = new Sprite(new Texture("bullet2.png")).getHeight();
    }

    CosmicBullet(Vector2 muzzle_position, Vector2 direction, int teamTag) {
        this.teamTag = teamTag;
        this.position = muzzle_position.cpy().add(direction.cpy().setLength(width / 2));
        this.velocity = direction.cpy().setLength(600); // speed
    }
}
