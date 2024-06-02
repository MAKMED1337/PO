package com.po.fuck.model.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.model.Entity;
import com.po.fuck.view.GifDecoder;

public final class LaserGun extends Gun {
    {
        cooldown = 1;

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal("laserGun.json"));
        muzzlePosition = new Vector2((float)base.getDouble("muzzlePositionX"), (float)base.getDouble("muzzlePositionY"));

        geometryData.setHeight(59);
        geometryData.setWidth(200);
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
