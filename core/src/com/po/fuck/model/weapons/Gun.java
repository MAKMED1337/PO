package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;

public abstract class Gun extends HandedWeapon implements Updatable {
    protected float cooldown;
    private float cooldownLeft = 0;
    Gun(Entity owner) {
        super(owner);
    }

    // something like bullet factory
    // should not perform any checks
    protected abstract Bullet shoot(Vector2 muzzlePosition, Vector2 direction);

    @Override
    public boolean attack() {
        if (aiming == null)
            return false;

        if (cooldownLeft > 0)
            return false;

        Vector2 direction = getDirection(), gunPosition = getPosition();

        gunPosition.add(new Vector2(geometryData.getWidth() / 2, 0).rotateRad(direction.angleRad()));
        Manager.create(shoot(gunPosition, getDirection()));

        cooldownLeft = cooldown;
        return true;
    }

    @Override
    public void update(float delta) {
        cooldownLeft = Math.max(0, cooldownLeft - delta);
    }
}
