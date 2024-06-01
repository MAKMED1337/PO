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

    public float getRotation(){
        return rotation;
    }

    public void setRotation(float angle){
        rotation = angle;
    }
}
