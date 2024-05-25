package com.po.fuck.model.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Drawable;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.collections.All;

import java.util.List;

public abstract class Bullet implements Drawable, Updatable {
    protected Sprite sprite;
    protected Vector2 position;
    protected Vector2 velocity;

    @Override
    public int get_z() {
        return 1;
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

        Polygon polygon = GeometryMisc.createRectangle(position, sprite);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (collidable instanceof Entity) {
                ((Entity) collidable).takeDamage(1);
                Manager.destroy_raw(this);

                return; // damage only 1 enemy at the same time
                // TODO: sort them by distance or something like this
            }
        }
    }
}
