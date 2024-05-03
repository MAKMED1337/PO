package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;

public interface IMovement {
    // outside parameter

    Vector2 getPosition();

    boolean setDirection(Vector2 direction);

    Vector2 getDirection();

    void update(float delta);
}
