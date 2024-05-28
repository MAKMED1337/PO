package com.po.fuck;

import static com.po.fuck.Constants.ENTITY_LAYER;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.movement.Movement;
import com.po.fuck.weapons.Weapon;

public class Entity extends GameObject {
    protected Managed<Movement> movement = new Managed<>();
    protected Managed<Weapon> weapon = new Managed<>();
    protected int teamTag;
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
        if (health_points == 0)
            Manager.destroy_raw(this);

        return true;
    }

    @Override
    public void destructor() {
        healthBar.destroy();
        weapon.destroy();
        super.destructor();
    }
}
