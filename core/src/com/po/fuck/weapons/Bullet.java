package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.CenterDrawer;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;
import com.po.fuck.collision.AABB;
import com.po.fuck.collision.Collidable;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;

import java.util.List;

public abstract class Bullet implements Drawable, Updatable {
    protected Sprite sprite;
    protected Vector2 position;
    protected Vector2 velocity;

    {
        FUCK.initializer.init(this);
    }

    public Vector2 getSize() {
        return new Vector2(sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void draw(CenterDrawer drawer) {
        sprite.setRotation(-velocity.angleDeg());
        drawer.draw(sprite, position);
    }

    @Override
    public void update(float delta) {
        position.mulAdd(velocity, delta);

        Vector2 size = getSize();
        AABB aabb = new AABB(position.cpy().mulAdd(size, -0.5f), position.cpy().mulAdd(size, 0.5f));
        List<Collidable> collidableList = FUCK.initializer.collidableCollection.collides(aabb);
        for (Collidable collidable : collidableList) {
            if (collidable instanceof Entity) {
                ((Entity) collidable).takeDamage(1);
                FUCK.initializer.dispose(this);
            }
        }
    }
}
