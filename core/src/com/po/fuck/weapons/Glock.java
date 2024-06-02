package com.po.fuck.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;

public class Glock extends Gun {
    {
        sprite = new Sprite(FUCK.assets.manager.get(Assets.glock2Texture));
        cooldown = 0.5f;

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal("glock.json"));
        muzzlePosition = new Vector2((float)base.getDouble("muzzlePositionX"), (float)base.getDouble("muzzlePositionY"));
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected void shoot(Vector2 muzzle_position, Vector2 direction) {
        new CosmicBullet(muzzle_position, direction);
    }
}
