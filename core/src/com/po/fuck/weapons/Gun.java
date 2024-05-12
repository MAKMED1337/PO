package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.CenterDrawer;
import com.po.fuck.Player;
import com.po.fuck.updates.Updatable;

import static com.po.fuck.Constants.DISTANCE_FACTOR;
import static com.po.fuck.Constants.MAX_DISTANCE_FROM_BODY;

public abstract class Gun extends Weapon implements Updatable {
    protected Sprite sprite;
    protected Vector2 aiming = null;
    protected float cooldown;

    private float cooldownLeft = 0;

    Gun(Player owner) {
        super(owner);
    }

    @Override
    public void aim(Vector2 pos) {
        aiming = pos;
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

        Vector2 direction = getDirection(), gunPosition = calcGunPosition().cpy();

        gunPosition.add(new Vector2(sprite.getWidth() / 2, 0).rotateRad(direction.angleRad()));
        shoot(gunPosition, getDirection());

        cooldownLeft = cooldown;
        return true;
    }

    protected Vector2 getDirection() {
        if (aiming == null)
            return new Vector2();
        return aiming.cpy().sub(owner.position);
    }

    protected Vector2 calcGunPosition() {
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

        drawer.draw(sprite, calcGunPosition());
    }

    @Override
    public void update(float delta) {
        cooldownLeft = Math.max(0, cooldownLeft - delta);
    }
}
