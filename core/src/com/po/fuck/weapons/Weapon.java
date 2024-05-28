package com.po.fuck.weapons;

import static com.po.fuck.Constants.WEAPON_LAYER;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;
import com.po.fuck.updates.Drawable;

public abstract class Weapon implements Drawable {
    protected final Entity owner;
    protected Sprite sprite;
    protected Vector2 aiming;

    @Override
    public int get_z() {
        return WEAPON_LAYER;
    }

    Weapon(Entity owner) {
        this.owner = owner;
    }

    public void aim(Vector2 position) {
        aiming = position.cpy();
    }

    public abstract boolean attack();

    public Vector2 getDirection() {
        if (aiming == null)
            return new Vector2();
        return aiming.cpy().sub(owner.position);
    }
}
