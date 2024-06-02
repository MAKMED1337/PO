package com.po.fuck.model.collision;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public interface Collidable {
    Vector2 getPosition();

    void setPosition(Vector2 position); // TODO: find something better

    Polygon getCollision();

    default boolean collide(Polygon other) {
        return Intersector.overlapConvexPolygons(getCollision(), other);
    }
}
