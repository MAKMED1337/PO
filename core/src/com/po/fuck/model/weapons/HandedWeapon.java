package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public abstract class HandedWeapon extends Weapon {
    protected float DISTANCE_FACTOR = 2, MAX_DISTANCE_FROM_BODY = 100;

    HandedWeapon(Entity owner) {
        super(owner);
    }

    public Vector2 getPosition() {
        Vector2 direction = getDirection();
        direction.setLength(Math.min(direction.len() / DISTANCE_FACTOR, MAX_DISTANCE_FROM_BODY));
        return owner.getPosition().add(direction);
    }
}
