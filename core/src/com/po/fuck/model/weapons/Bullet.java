package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Drawable;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.collections.All;

import static com.po.fuck.model.Constants.DEFAULT_BULLET_LIFE_TIME;
import static com.po.fuck.model.Constants.WEAPON_LAYER;

import java.util.List;

public abstract class Bullet implements Drawable, Updatable {
    protected GeometryData geometryData;
    protected Vector2 velocity;
    protected int teamTag;
    protected float damage;
    protected float lifeTime = DEFAULT_BULLET_LIFE_TIME; // default lifetime is set to 60 seconds
    protected float elapsedTime = 0;

	@Override
    public int get_z() {
        return WEAPON_LAYER;
    }
    
    @Override
    public Vector2 getPosition() {
        return geometryData.getPosition();
    }

    public Vector2 getVelocity(){
        return velocity.cpy();
    }

    protected boolean tryDamage(Entity entity, float damage) {
        if (entity.getTeamTag() == this.teamTag)
            return false;
        entity.takeDamage(damage);
        return true;
    }

    @Override
    public void update(float delta) {
        geometryData.setPosition(getPosition().mulAdd(velocity, delta));

        elapsedTime += delta;

        if(elapsedTime > lifeTime){
            Manager.destroy_raw(this);
            return;
        }

        Polygon polygon = GeometryMisc.createRectangle(getPosition(), geometryData.getWidth(), geometryData.getHeight(), velocity.angleDeg());
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity)) {
                Manager.destroy_raw(this);
                return;
            }

            Entity enemy = (Entity) collidable;
            if (this.tryDamage(enemy, damage)) {
                Manager.destroy_raw(this);
                return; // damage only 1 enemy at the same time
                // TODO: sort them by distance or something like this
            }
        }
    }

    public float getElapsedTime() {
        return elapsedTime;
    }

    @Override
    public GeometryData getGeometryData() {
        return new GeometryData(geometryData);
    }
}
