package com.po.fuck.model.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.model.Entity;
import com.po.fuck.model.position.GeometryData;

public final class Glock extends Gun {
    {
        cooldown = 0.5f;

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal("glock.json"));
        muzzlePosition = new Vector2((float)base.getDouble("muzzlePositionX"), (float)base.getDouble("muzzlePositionY"));
        geometryData.setHeight(64);
        geometryData.setWidth(100);

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
