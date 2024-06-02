package com.po.fuck.model;

import static com.po.fuck.model.Constants.ENTITY_LAYER;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.Movement;
import com.po.fuck.model.weapons.Weapon;

public class Entity extends GameObject {
    protected Managed<Movement> movement = new Managed<>();
    protected Managed<Weapon> weapon = new Managed<>();
    protected int teamTag;

    protected int reward = 0;
    protected float health_points;
    public final float MAX_HEALTH_POINTS;
    protected boolean immortal = false;

    public Entity(Vector2 position, float width, float height, float HP) {
        super(position,width,height);
        this.MAX_HEALTH_POINTS = HP;
        this.health_points = HP;
    }

    public int getTeamTag() {
        return teamTag;
    }

    @Override
    public int get_z() {
        return ENTITY_LAYER;
    }

    public boolean isAlive() {
        return immortal || health_points > 0;
    }

    public boolean takeDamage(float damage) {
        if (immortal)
            return false;

        health_points = Math.max(0, health_points - damage);
        if (health_points == 0) {
            Core.coinsCounter.get().addCoins(reward);
            Manager.destroy_raw(this);
        }

        return true;
    }

    public float getHP(){
        return health_points;
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
