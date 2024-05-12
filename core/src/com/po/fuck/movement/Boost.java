package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.FUCK;

// should be used as a last class in a movement chain
public class Boost implements IMovement {
    {
        FUCK.initializer.init(this);
    }

    private final IMovement movement;
    private final int boostDistance;
    private final float boostCooldown, boostDuration;
    private float timeSinceLastBoost;

    public Boost(IMovement movement, int boostDistance, float boostDuration, float boostCooldown) {
        FUCK.initializer.dispose(movement);

        this.movement = movement;

        this.boostCooldown = boostCooldown;
        this.boostDistance = boostDistance;
        this.boostDuration = boostDuration;
        this.timeSinceLastBoost = boostCooldown;
    }

    @Override
    public void update(float delta) {
        float nextDelta = delta;
        if (timeSinceLastBoost < boostDuration) {
            float boostTime = Math.min(delta, boostDuration - timeSinceLastBoost);
            float progress = boostTime / boostDuration;
            movement.getPosition().add(movement.getDirection().cpy().setLength(progress * boostDistance));
            nextDelta = delta - boostTime; // for the future movement
        }

        movement.update(nextDelta);
        timeSinceLastBoost += delta;
    }

    public boolean isBoosted() {
        return timeSinceLastBoost < boostDuration;
    }

    public boolean canUseBoost() {
        return timeSinceLastBoost >= boostCooldown;
    }

    public boolean tryToUseBoost() {
        if (!canUseBoost())
            return false;

        timeSinceLastBoost = 0;
        return true;
    }

    @Override
    public Vector2 getPosition() {
        return movement.getPosition();
    }

    @Override
    public boolean setDirection(Vector2 direction) {
        if (isBoosted())
            return false;

        return movement.setDirection(direction);
    }

    @Override
    public Vector2 getDirection() {
        return movement.getDirection();
    }
}
