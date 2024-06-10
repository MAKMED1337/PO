package com.po.fuck.model.weapons;

import static com.po.fuck.model.Constants.DEFAULT_DISTANCE_FACTOR;
import static com.po.fuck.model.Constants.DEFAULT_MAX_DISTANCE_FROM_BODY;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.position.GeometryData;

public abstract class HandedWeapon extends Weapon {
    protected float DISTANCE_FACTOR = DEFAULT_DISTANCE_FACTOR, MAX_DISTANCE_FROM_BODY = DEFAULT_MAX_DISTANCE_FROM_BODY;

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
