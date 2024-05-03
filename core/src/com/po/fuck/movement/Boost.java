package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;

// should be used as a last class in a movement chain
public class Boost implements IMovement {
    private final IMovement movement;
    private final int boost_distance;
    private final float boost_cooldown, boost_duration;
    private float time_since_last_boost;

    public Boost(IMovement movement, int boost_distance, float boost_duration, float boost_cooldown) {
        this.movement = movement;

        this.boost_cooldown = boost_cooldown;
        this.boost_distance = boost_distance;
        this.boost_duration = boost_duration;
        this.time_since_last_boost = boost_cooldown;
    }

    @Override
    public void update(float full_delta) {
        float delta = full_delta;
        if (time_since_last_boost < boost_duration) {
            float boost_time = Math.min(delta, boost_duration - time_since_last_boost);
            float progress = boost_time / boost_duration;
            movement.getPosition().add(movement.getDirection().cpy().setLength(progress * boost_distance));
            delta = delta - boost_time; // for the future movement
        }

        movement.update(delta);
        time_since_last_boost += full_delta;
    }

    public boolean is_boosted() {
        return time_since_last_boost < boost_duration;
    }

    public boolean can_use_boost() {
        return time_since_last_boost >= boost_cooldown;
    }

    public boolean try_to_use_boost() {
        if (!can_use_boost())
            return false;

        time_since_last_boost = 0;
        return true;
    }

    @Override
    public Vector2 getPosition() {
        return movement.getPosition();
    }

    @Override
    public boolean setDirection(Vector2 direction) {
        if (is_boosted())
            return false;

        return movement.setDirection(direction);
    }

    @Override
    public Vector2 getDirection() {
        return movement.getDirection();
    }
}
