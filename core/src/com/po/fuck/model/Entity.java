package com.po.fuck.model;

import static com.po.fuck.model.Constants.ENTITY_LAYER;

import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.Movement;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.weapons.Weapon;

public class Entity extends GameObject {
    protected Managed<Movement> movement = new Managed<>();
    protected Managed<Weapon> weapon = new Managed<>();
    protected int teamTag;

    protected int reward = 0;
    protected float healthPoints;
    public final float MAX_HEALTH_POINTS;
    protected boolean immortal = false;

    public Entity(GeometryData geometryData, float HP) {
        super(geometryData);
        this.MAX_HEALTH_POINTS = HP;
        this.healthPoints = HP;
    }

    public int getTeamTag() {
        return teamTag;
    }

    @Override
    public int getZ() {
        return ENTITY_LAYER;
    }

    public boolean isAlive() {
        return immortal || healthPoints > 0;
    }

    public boolean takeDamage(float damage) {
        if (immortal)
            return false;

        healthPoints = Math.max(0, healthPoints - damage);
        if (healthPoints == 0) {
            Core.coinsCounter.get().addCoins(reward);
            Manager.destroyRaw(this);
        }

        return true;
    }

    public float getHP(){
        return healthPoints;
    }

    public Managed<Movement> getMovement(){
        return movement;
    }

    public Managed<Weapon> getWeapon(){
        return weapon;
    }

    @Override
    public void destructor() {
        weapon.destroy();
        super.destructor();
    }
}
