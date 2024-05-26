package com.po.fuck.weapons;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;
import com.po.fuck.GeometryMisc;
import com.po.fuck.GifDecoder;
import com.po.fuck.collision.Collidable;
import com.po.fuck.collections.All;
import com.po.fuck.lifetime.Manager;

public final class LaserBeam extends Bullet {
    // version is also good, but for some reason it renders with artifacts
    static private final Animation<TextureRegion> animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read());
    private final float LIVE_TIME = 1;
    private float timeElapsed = 0;

    {
        this.sprite = new Sprite(animation.getKeyFrame(0));
    }

    LaserBeam(Vector2 muzzle_position, Vector2 direction, int teamTag) {
        this.teamTag = teamTag;
        this.position = muzzle_position.cpy().add(direction.cpy().setLength(sprite.getWidth() / 2));
        this.velocity = direction.cpy().setLength(0.1f);
    }

    @Override
    public void update(float delta) {
        timeElapsed += delta;
        this.sprite = new Sprite(animation.getKeyFrame(timeElapsed));
        sprite.setRotation(-velocity.angleDeg());

        if (timeElapsed > LIVE_TIME) {
            Manager.destroy_raw(this);
            return;
        }

        Polygon polygon = GeometryMisc.createRectangle(position, sprite);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) continue;
            Entity enemy = (Entity) collidable;
            if (this.canDamage(enemy))
                enemy.takeDamage(3 * delta);
        }
    }
}
