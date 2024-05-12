package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Updatable;

public interface IMovement extends Updatable {
    // outside parameter

    Vector2 getPosition();

    boolean setDirection(Vector2 direction);

    Vector2 getDirection();
}
