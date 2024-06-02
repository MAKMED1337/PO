package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class Glock extends Gun {
    {
        // width = new Sprite(new Texture("glock3.png")).getWidth();
        // height = new Sprite(new Texture("glock3.png")).getHeight();
        cooldown = 0.5f;
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new CosmicBullet(muzzle_position, new Sprite(new Texture("bullet2.png")).getWidth(),
                                                new Sprite(new Texture("bullet2.png")).getHeight(),
                                                direction, owner.getTeamTag());
    }
}
