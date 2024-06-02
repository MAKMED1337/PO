package com.po.fuck.model.weapons;

import static com.po.fuck.model.Constants.WEAPON_LAYER;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.Drawable;

public abstract class Weapon implements Drawable, Updatable {
    protected final Entity owner;
    protected Vector2 aiming = new Vector2();
    protected GeometryData geometryData = new GeometryData();
    protected float elapsedTime = 0;

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
    public void update(float delta){
        elapsedTime += delta;
    }

    public float getElapsedTime(){
        return elapsedTime;
    }

    @Override
    public GeometryData getGeometryData(){
        return new GeometryData(geometryData);
    }
}
