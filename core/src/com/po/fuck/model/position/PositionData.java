package com.po.fuck.model.position;

import com.badlogic.gdx.math.Vector2;

public class PositionData {
    protected Vector2 position;

    protected float rotation; /* in rads */

    public PositionData() {
        this.position = new Vector2();
    }

    public PositionData(Vector2 position, float rotation) {
        this.position = new Vector2(position);
        this.rotation = rotation;
    }

    public PositionData(Vector2 position) {
        this.position = new Vector2(position);
        rotation = 0;
    }

    public PositionData(PositionData positionData) {
        this.position = positionData.position.cpy();
        this.rotation = positionData.rotation;
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public void setPosition(Vector2 newPosition) {
        this.position = newPosition.cpy();
    }

    public float getRotationRad() {
        return rotation;
    }

    public void setRotationRad(float angle) {
        rotation = angle;
    }

    public float getRotationDeg() {
        return (float) (rotation * 180 / Math.PI);
    }

    public void setRotationDeg(float angle) {
        rotation = (float) (angle * Math.PI / 180f);
    }
}
