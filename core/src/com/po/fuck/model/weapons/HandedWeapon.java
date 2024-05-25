package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.model.Entity;

public abstract class HandedWeapon extends Weapon {
    protected float DISTANCE_FACTOR = 2, MAX_DISTANCE_FROM_BODY = 100;

    HandedWeapon(Entity owner) {
        super(owner);
    }

    protected Vector2 calcWeaponPosition() {
        Vector2 direction = getDirection();
        direction.setLength(Math.min(direction.len() / DISTANCE_FACTOR, MAX_DISTANCE_FROM_BODY));
        return owner.position.cpy().add(direction);
    }

    @Override
    public void draw(CenterDrawer drawer) {
        if (aiming == null)
            return;

        Vector2 direction = getDirection();
        float angle = direction.angleDeg();
        sprite.setRotation(-angle);
        sprite.setFlip(false, angle >= 90 && angle <= 270);

        drawer.draw(sprite, calcWeaponPosition());
    }
}
