package com.po.fuck.model.weapons;

import static com.po.fuck.model.constants.BulletsConstants.LASER_BEAM_DAMAGE;
import static com.po.fuck.model.constants.BulletsConstants.LASER_BEAM_LIFE_TIME;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.view.GifDecoder;
import com.po.fuck.model.collections.All;

public final class LaserBeam extends Bullet {

    {
        damage = LASER_BEAM_DAMAGE;
        lifeTime = LASER_BEAM_LIFE_TIME;
        geometryData = new GeometryData();
        geometryData.setWidth(new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getWidth());
        geometryData.setHeight(new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
                                .getKeyFrame(0)).getHeight());
    }

    LaserBeam(Vector2 muzzlePosition, Vector2 direction, int teamTag) {
        geometryData.setPosition(muzzlePosition.cpy().add(direction.cpy().setLength(geometryData.getWidth() / 2)));
        this.teamTag = teamTag;
        velocity = direction.cpy().setLength(0.1f);
    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;

        if (elapsedTime > lifeTime) {
            Manager.destroyRaw(this);
            return;
        }

        geometryData.setRotationRad(velocity.angleRad());

        Polygon polygon = GeometryMisc.createRectangle(geometryData);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity enemy)) continue;
            tryDamage(enemy, delta * damage);
        }
    }
}
