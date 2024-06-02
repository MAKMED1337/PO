package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;

public final class Glock extends Gun {
    {
        cooldown = 0.5f;
    }

    public Glock(Entity owner) {
        super(owner);
        name = "glock";

        JsonValue info = Assets.getInfo(name);

        geometryData.setHeight(info.getInt("height"));
        geometryData.setWidth(info.getInt("width"));
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new CosmicBullet(muzzle_position, new Sprite(new Texture("bullet2.png")).getWidth(),
                                                new Sprite(new Texture("bullet2.png")).getHeight(),
                                                direction, owner.getTeamTag());
    }
}
