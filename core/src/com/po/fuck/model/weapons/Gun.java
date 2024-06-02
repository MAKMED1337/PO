package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.GeometryMisc;

public abstract class Gun extends HandedWeapon implements Updatable {
    protected float cooldown;
    private float cooldownLeft = 0;

    protected String name;
    Gun(Entity owner) {
        super(owner);
    }

    // something like bullet factory
    // should not perform any checks
    protected abstract Bullet shoot(Vector2 muzzle_position, Vector2 direction);

    @Override
    public boolean attack() {
        if (aiming == null)
            return false;

        if (cooldownLeft > 0)
            return false;

        Vector2 direction = getDirection(), gunPosition = getPosition();
        gunPosition.add(new Vector2(geometryData.getWidth() / 2, 0).rotateRad(direction.angleRad()));

        JsonValue info = Assets.getInfo(name);
        Vector2 realMuzzlePosition = new Vector2((float) info.getDouble("muzzlePositionX"),
                (float) info.getDouble("muzzlePositionY"));

        realMuzzlePosition.x -= geometryData.getWidth();
        realMuzzlePosition.y -= geometryData.getHeight()/2;

        boolean flipped = direction.angleDeg() >= 90 && direction.angleDeg() <= 270;

        Vector2 finalPosition = GeometryMisc.getPointPositionOnFlippedSprite(gunPosition.cpy(), direction.cpy(),
                realMuzzlePosition, flipped);

        Manager.create(shoot(finalPosition, direction));

        cooldownLeft = cooldown;
        return true;
    }

    @Override
    public void update(float delta) {
        cooldownLeft = Math.max(0, cooldownLeft - delta);
    }
}
