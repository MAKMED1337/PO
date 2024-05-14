package com.po.fuck;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.Movement;
import com.po.fuck.weapons.Weapon;

public class Entity extends GameObject {
    protected Movement movement = null;
    protected Weapon weapon = null;

    protected float health_points;
    public final float MAX_HEALTH_POINTS;
    protected boolean immortal = false;

    public HealthBar healthBar;

    public Entity(Vector2 position, float HP) {
        super(position);
        this.MAX_HEALTH_POINTS = HP;
        this.health_points = HP;
        healthBar = new HealthBar(this);
    }

    public boolean isAlive() {
        return immortal || health_points > 0;
    }

    public boolean takeDamage(float damage) {
        if (immortal)
            return false;

        health_points = Math.max(0, health_points - damage);
        if (health_points == 0)
            dispose();

        return true;
    }

    @Override
    public void dispose() {
        FUCK.initializer.dispose(healthBar);
        FUCK.initializer.dispose(weapon);
        super.dispose();
    }
}
