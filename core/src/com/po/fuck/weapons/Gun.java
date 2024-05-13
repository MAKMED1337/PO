package com.po.fuck.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;
import com.po.fuck.updates.Updatable;

public abstract class Gun extends HandedWeapon implements Updatable {
    protected float cooldown;

    private float cooldownLeft = 0;

    Gun(Entity owner) {
        super(owner);
    }

    // something like bullet factory
    // should not perform any checks
    protected abstract void shoot(Vector2 muzzle_position, Vector2 direction);

    @Override
    public boolean attack() {
        if (aiming == null)
            return false;

        if (cooldownLeft > 0)
            return false;

        Vector2 direction = getDirection(), gunPosition = calcWeaponPosition().cpy();

        gunPosition.add(new Vector2(sprite.getWidth() / 2, 0).rotateRad(direction.angleRad()));
        shoot(gunPosition, getDirection());

        cooldownLeft = cooldown;
        return true;
    }

    @Override
    public void update(float delta) {
        cooldownLeft = Math.max(0, cooldownLeft - delta);
    }
}
