package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.FUCK;
import com.po.fuck.collision.Collidable;
import com.po.fuck.updates.Updatable;

import static com.po.fuck.Constants.COLLISION_ITERATIONS;

public abstract class Movement implements Updatable {
    protected Collidable collidable;
    Vector2 direction;

    {
        FUCK.initializer.init(this);
    }

    boolean setDirection(Vector2 direction) {
        this.direction = direction;
        return true;
    }

    protected void move(Vector2 delta) {
        // do like a binary search try to move 1/2 of a delta, then 1/4, 1/8, ...
        Vector2 currentDelta = delta.cpy();
        for (int iter = 0; iter < COLLISION_ITERATIONS; ++iter) {
            if (iter + 1 < COLLISION_ITERATIONS)
                currentDelta = delta.scl(0.5f);

            Vector2 position = collidable.getPosition();

            collidable.setPosition(position.cpy().add(currentDelta)); // try to move

            // check all the collisions with the new position
            boolean selfOnly = true;
            for (Collidable object : FUCK.initializer.collidableCollection.collides(collidable.getCollision()))
                selfOnly &= object.equals(collidable);

            if (!selfOnly) // if this object collides with something (other than self)
                collidable.setPosition(position); // then rollback
        }
    }
}