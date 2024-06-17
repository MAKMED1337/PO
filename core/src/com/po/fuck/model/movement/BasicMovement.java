package com.po.fuck.model.movement;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;

public class BasicMovement extends Movement {
    private final float speed;

    public BasicMovement(Collidable collidable, float speed) {
        direction = new Vector2(0, 0);

        this.collidable = collidable;
        this.speed = speed;
    }

    /**
     * Sets the direction of movement for the object.
     *
     * @param direction The direction vector indicating the movement direction.
     * @return true if the direction was successfully set, false otherwise.
     */
    public boolean setDirection(Vector2 direction) {
        this.direction = direction;
        return true;
    }

    /**
     * Updates the position of the object based on its current direction and speed.
     *
     * @param delta The time elapsed since the last update, in seconds.
     *              This parameter allows the object to adjust its movement based on
     *              the
     *              passage of time and ensures smooth animation and interaction.
     */
    @Override
    public void update(float delta) {
        Vector2 velocity = this.direction.cpy().setLength(speed);
        move(velocity.scl(delta));
    }
}
