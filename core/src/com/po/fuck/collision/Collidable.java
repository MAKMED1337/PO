package com.po.fuck.collision;

import com.badlogic.gdx.math.Vector2;

public interface Collidable {
    Vector2 getPosition();

    void setPosition(Vector2 position); // TODO: find something better

    AABB getCollision();

    default boolean collide(AABB other) {
        return getCollision().intersects(other);
    }
}
