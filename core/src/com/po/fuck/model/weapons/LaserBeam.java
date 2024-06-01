package com.po.fuck.model.weapons;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.view.GifDecoder;
import com.po.fuck.model.collections.All;

import static com.po.fuck.model.Constants.LASER_BEAM_DAMAGE;
import static com.po.fuck.model.Constants.LASER_BEAM_LIFE_TIME;

public final class LaserBeam extends AnimatedBullet  {
    // version is also good, but for some reason it renders with artifacts

    {
        AnimatedBullet.addAnimation(LaserBeam.class, GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read()));
        damage = LASER_BEAM_DAMAGE;
        sprite = new Sprite(getAnimation().getKeyFrame(0));
        lifeTime = LASER_BEAM_LIFE_TIME;
    }

    LaserBeam(Vector2 muzzle_position, Vector2 direction, int teamTag) {
        this.teamTag = teamTag;
        this.position = muzzle_position.cpy().add(direction.cpy().setLength(sprite.getWidth() / 2));
        this.velocity = direction.cpy().setLength(0.1f);
    }

    @Override
    public void update(float delta) {
        timeElapsed += delta;

        if (timeElapsed > lifeTime) {
            Manager.destroy_raw(this);
            return;
        }

        sprite.setRotation(-velocity.angleDeg()); // Currently needed for Collisions

        Polygon polygon = GeometryMisc.createRectangle(position, sprite);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) continue;
            Entity enemy = (Entity) collidable;
            this.tryDamage(enemy, delta*damage);
        }
    }

    public Animation<TextureRegion> getAnimation() {
        return AnimatedBullet.getAnimation(LaserBeam.class);
    }
}
