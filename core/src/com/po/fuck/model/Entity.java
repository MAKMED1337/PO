package com.po.fuck.model;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscriber;

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

    private SubmissionPublisher<Entity> deathPublisher = new SubmissionPublisher<>();

    public Entity(GeometryData geometryData, float HP) {
        super(geometryData);
        this.MAX_HEALTH_POINTS = HP;
        this.healthPoints = HP;
    }

    public void onDeath(Subscriber<Entity> subscriber) {
        deathPublisher.subscribe(subscriber);
    }

    public int getTeamTag() {
        return teamTag;
    }

    public boolean isAlive() {
        return immortal || healthPoints > 0;
    }

    public boolean takeDamage(float damage) {
        if (immortal)
            return false;

        healthPoints = Math.max(0, healthPoints - damage);
        if (healthPoints == 0)
            die();

        return true;
    }

    protected void die() {
        deathPublisher.submit(this);
        Manager.destroyRaw(this);
    }

    public float getHP() {
        return healthPoints;
    }

    public int getReward() {
        return reward;
    }

    public Managed<Movement> getMovement() {
        return movement;
    }

    public Managed<Weapon> getWeapon() {
        return weapon;
    }

    @Override
    public void destructor() {
        weapon.destroy();
        super.destructor();
    }
}
