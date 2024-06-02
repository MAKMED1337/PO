package com.po.fuck.model.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;
import com.po.fuck.view.GifDecoder;

public final class LaserGun extends Gun {
    {
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
        name = "laserGun";

        JsonValue info = Assets.getInfo(name);
        geometryData.setHeight(info.getInt("height"));
        geometryData.setWidth(info.getInt("width"));
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getWidth(),
                                new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getHeight(), direction, owner.getTeamTag());
    }
}
