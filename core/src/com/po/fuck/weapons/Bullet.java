package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.CenterDrawer;
import com.po.fuck.Entity;
import com.po.fuck.GeometryMisc;
import com.po.fuck.collision.Collidable;
import com.po.fuck.collections.All;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;
import com.po.fuck.lifetime.Manager;

import java.util.List;

public abstract class Bullet implements Drawable, Updatable {
    protected Sprite sprite;
    protected Vector2 position;
    protected Vector2 velocity;
    protected int teamTag;
    @Override
    public int get_z() {
        return 1;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        sprite.setRotation(-velocity.angleDeg());
        drawer.draw(sprite, position);
    }
    protected boolean canDamage(Entity entity) {
        return entity.getTeamTag() != this.teamTag;
    }

    @Override
    public void update(float delta) {
        position.mulAdd(velocity, delta);

        Polygon polygon = GeometryMisc.createRectangle(position, sprite);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) continue;
            Entity enemy = (Entity) collidable;
            if (this.canDamage(enemy)) {
                enemy.takeDamage(1);
                Manager.destroy_raw(this);

                return; // damage only 1 enemy at the same time
                // TODO: sort them by distance or something like this
            }
        }
    }
}
