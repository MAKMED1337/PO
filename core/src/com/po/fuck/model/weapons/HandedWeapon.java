package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.position.GeometryData;

public abstract class HandedWeapon extends Weapon {
    protected float DISTANCE_FACTOR = 2, MAX_DISTANCE_FROM_BODY = 100;

    HandedWeapon(Entity owner) {
        super(owner);
    }

    @Override 
    public GeometryData getGeometryData() {
        Vector2 direction = getDirection();
        direction.setLength(Math.min(direction.len() / DISTANCE_FACTOR, MAX_DISTANCE_FROM_BODY));
        geometryData.setPosition(owner.getPosition().add(direction));

        return geometryData;
    }

    @Override
    public Vector2 getPosition(){
        return getGeometryData().getPosition();
    }
}
