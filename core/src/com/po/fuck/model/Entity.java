package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.controller.movement.Movement;
import com.po.fuck.view.HealthBar;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.weapons.Weapon;

public class Entity extends GameObject {
    protected Managed<Movement> movement = new Managed<>();
    protected Managed<Weapon> weapon = new Managed<>();

    protected float health_points;
    public final float MAX_HEALTH_POINTS;
    protected boolean immortal = false;

    public Managed<HealthBar> healthBar;

    public Entity(Vector2 position, float HP) {
        super(position);
        this.MAX_HEALTH_POINTS = HP;
        this.health_points = HP;
        healthBar = Manager.create(new HealthBar(this));
    }

    public boolean isAlive() {
        return immortal || health_points > 0;
    }

    public boolean takeDamage(float damage) {
        if (immortal)
            return false;

        health_points = Math.max(0, health_points - damage);
        if (health_points == 0)
            Manager.destroy_raw(this);

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
        healthBar.destroy();
        weapon.destroy();
        super.destructor();
    }
}
