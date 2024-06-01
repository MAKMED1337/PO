package com.po.fuck.model.position;

import com.badlogic.gdx.math.Vector2;

public class SimplePosition {
    protected Vector2 position;
    protected float rotation; /* in rads */

    public SimplePosition(Vector2 position, float rotation){
        this.position = position.cpy();
        this.rotation = rotation;
    }

    public Vector2 getPosition(){
        return position.cpy();
    }

    public void setPosition(Vector2 newPosition){
        this.position = newPosition.cpy();
    }

    public float getRotationRad(){
        return rotation;
    }

    public void setRotationRad(float angle){
        rotation = angle;
    }

    public float getRotationDeg(){
        return (float) (rotation * 180 / Math.PI);
    }

    public void setRotationDeg(float angle){
        rotation = (float) (angle * Math.PI / 180f);
    }
}
