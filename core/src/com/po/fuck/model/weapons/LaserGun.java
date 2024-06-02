package com.po.fuck.model.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.view.GifDecoder;

public final class LaserGun extends Gun {
    {
        cooldown = 1;
    }

    public LaserGun(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzle_position, Vector2 direction) {
        return new LaserBeam(muzzle_position, new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getWidth(),
                                new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getHeight(), direction, owner.getTeamTag());
    }
}
