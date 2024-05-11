package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;

public class BasicMovement implements IMovement {
    private final int speed;
    protected Vector2 direction = new Vector2(0, 0);
    protected Vector2 position;

    public BasicMovement(Vector2 position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public boolean setDirection(Vector2 direction) {
        this.direction = direction;
        return true;
    }

    @Override
    public Vector2 getDirection() {
        return direction;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void update(float delta) {
        Vector2 velocity = this.direction.cpy().setLength(speed);
        position.mulAdd(velocity, delta);
    }
}
