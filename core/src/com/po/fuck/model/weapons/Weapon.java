package com.po.fuck.model.weapons;

import static com.po.fuck.model.Constants.WEAPON_LAYER;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.drawables.Drawable;
import com.po.fuck.model.position.GeometryData;

public abstract class Weapon implements Drawable {
    protected final Entity owner;
    protected Vector2 aiming = new Vector2();
    protected GeometryData geometryData = new GeometryData();

    @Override
    public int get_z() {
        return WEAPON_LAYER;
    }

    Weapon(Entity owner) {
        this.owner = owner;
    }

    public Vector2 getAimPosition(){
        return aiming.cpy();
    }

    public void aim(Vector2 position) {
        aiming = position.cpy();
    }

    public abstract boolean attack();

    public Vector2 getDirection() {
        if (aiming == null)
            return new Vector2();
        return aiming.cpy().sub(owner.getPosition());
    }

    @Override
    public GeometryData getGeometryData(){
        return new GeometryData(geometryData);
    }
}
