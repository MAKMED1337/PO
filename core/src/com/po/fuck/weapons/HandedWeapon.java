package com.po.fuck.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.CenterDrawer;
import com.po.fuck.Entity;
import com.po.fuck.GeometryMisc;

public abstract class HandedWeapon extends Weapon {
    protected float DISTANCE_FACTOR = 2, MAX_DISTANCE_FROM_BODY = 100;

    protected float muzzleShift;

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

        Vector2 dirToMove;
        if (angle >= 90 && angle <= 270) dirToMove = direction.rotate90(-1);
        else dirToMove = direction.rotate90(1);

        Vector2 pos = GeometryMisc.movePointInDirection(calcWeaponPosition(), dirToMove, muzzleShift);

        drawer.draw(sprite, pos);
    }
}
