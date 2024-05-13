package com.po.fuck.movement;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.FUCK;

public class BasicMovement implements IMovement {
    {
        FUCK.initializer.init(this);
    }

    private final int speed;
    protected Vector2 direction = new Vector2(0, 0);
    protected Vector2 position;

    /**
     * Constructs a BasicMovement object with the given position and speed.
     * 
     * @param position The initial position of the object.
     * @param speed The movement speed of the object.
     */
    public BasicMovement(Vector2 position, int speed) {
        this.position = position;
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

    @Override
    public Vector2 getDirection() {
        return direction;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Updates the position of the object based on its current direction and speed.
     * 
     * @param delta The time elapsed since the last update, in seconds.
     *              This parameter allows the object to adjust its movement based on the
     *              passage of time and ensures smooth animation and interaction.
     */
    @Override
    public void update(float delta) {
        Vector2 velocity = this.direction.cpy().setLength(speed);
        position.mulAdd(velocity, delta);
    }
}
