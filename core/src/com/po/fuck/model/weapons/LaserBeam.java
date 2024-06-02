package com.po.fuck.model.weapons;

import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.collections.All;

import static com.po.fuck.model.Constants.LASER_BEAM_DAMAGE;
import static com.po.fuck.model.Constants.LASER_BEAM_LIFE_TIME;

public final class LaserBeam extends Bullet {
    // version is also good, but for some reason it renders with artifacts

    {
        damage = LASER_BEAM_DAMAGE;
        lifeTime = LASER_BEAM_LIFE_TIME;
        /* Temp solution, afterwards use AssetManager or .properties later */
        // width = new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
        //                         .getKeyFrame(0)).getWidth();
        // height = new Sprite(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())
        //                         .getKeyFrame(0)).getHeight();
    }

    LaserBeam(Vector2 muzzle_position, float width, float height, Vector2 direction, int teamTag) {
        this.geometryData = new GeometryData();
        this.geometryData.setHeight(height);
        this.geometryData.setWidth(width);
        this.geometryData.setPosition(muzzle_position.cpy().add(direction.cpy().setLength(width / 2)));
        this.teamTag = teamTag;
        this.velocity = direction.cpy().setLength(0.1f);
    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;

        if (elapsedTime > lifeTime) {
            Manager.destroy_raw(this);
            return;
        }

        Polygon polygon = GeometryMisc.createRectangle(getPosition(), geometryData.getWidth(), geometryData.getHeight(), velocity.angleDeg());
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) continue;
            Entity enemy = (Entity) collidable;
            this.tryDamage(enemy, delta*damage);
        }
    }
}
