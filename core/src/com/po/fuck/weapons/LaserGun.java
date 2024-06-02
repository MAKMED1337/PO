package com.po.fuck.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;
import com.po.fuck.Player;

public final class LaserGun extends Gun {
    {
        sprite = new Sprite(FUCK.assets.manager.get(Assets.laserGunTexture));
        cooldown = 1;

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal("laserGun.json"));
        muzzlePosition = new Vector2((float)base.getDouble("muzzlePositionX"), (float)base.getDouble("muzzlePositionY"));
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected void shoot(Vector2 muzzle_position, Vector2 direction) {
        new LaserBeam(muzzle_position, direction);
    }
}
