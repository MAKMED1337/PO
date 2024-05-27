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

import static com.po.fuck.Constants.WEAPON_LAYER;

import java.util.List;

public abstract class Bullet implements Drawable, Updatable {
    protected Sprite sprite;
    protected Vector2 position;
    protected Vector2 velocity;
    protected int teamTag;
    protected float damage;

    @Override
    public int get_z() {
        return WEAPON_LAYER;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        sprite.setRotation(-velocity.angleDeg());
        drawer.draw(sprite, position);
    }
    protected boolean tryDamage(Entity entity, float damage) {
        if (entity.getTeamTag() == this.teamTag) return false;
        entity.takeDamage(damage);
        return true;
    }

    @Override
    public void update(float delta) {
        position.mulAdd(velocity, delta);

        Polygon polygon = GeometryMisc.createRectangle(position, sprite);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) continue;
            Entity enemy = (Entity) collidable;
            if (this.tryDamage(enemy, damage)) {
                Manager.destroy_raw(this);
                return; // damage only 1 enemy at the same time
                // TODO: sort them by distance or something like this
            }
        }
    }
}
