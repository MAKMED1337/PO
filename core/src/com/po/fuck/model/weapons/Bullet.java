package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.drawables.PositionDrawable;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.collections.All;

import static com.po.fuck.model.constants.BulletsConstants.DEFAULT_BULLET_LIFE_TIME;
import static com.po.fuck.model.constants.LayeringConstants.WEAPON_LAYER;

import java.util.List;

public abstract class Bullet implements PositionDrawable, Updatable {
    protected GeometryData geometryData;
    protected Vector2 velocity;
    protected int teamTag;
    protected float damage;
    protected float lifeTime = DEFAULT_BULLET_LIFE_TIME;
    protected float elapsedTime = 0;

    @Override
    public Vector2 getPosition() {
        return geometryData.getPosition();
    }

    public Vector2 getVelocity() {
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

        if (elapsedTime > lifeTime) {
            Manager.destroyRaw(this);
            return;
        }

        geometryData.setRotationRad(velocity.angleRad());

        Polygon polygon = GeometryMisc.createRectangle(geometryData);
        List<Collidable> collidableList = All.collidableCollection.collides(polygon);
        for (Collidable collidable : collidableList) {
            if (!(collidable instanceof Entity enemy)) {
                Manager.destroyRaw(this);
                return;
            }

            if (this.tryDamage(enemy, damage)) {
                Manager.destroyRaw(this);
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
