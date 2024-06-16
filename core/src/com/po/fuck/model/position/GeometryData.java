package com.po.fuck.model.position;

import com.badlogic.gdx.math.Vector2;

public class GeometryData {
    protected Vector2 position;
    protected float rotation; /* in rads */
    protected float width;
    protected float height;

    public GeometryData(){}

    public GeometryData(Vector2 position, float rotation){
        this.position = position.cpy();
        this.rotation = rotation;
    }


    public GeometryData(Vector2 position, float width, float height, float rotation){
        if(width <= 0 || height <= 0)
            throw new RuntimeException("Height and width have to be positive");
        this.position = position.cpy();
        this.rotation = rotation;
        this.width = width;
        this.height = height;
    }

    public GeometryData(GeometryData other){
        this.position = other.position.cpy();
        this.rotation = other.rotation;
        this.width = other.width;
        this.height = other.height;
    }

    public Vector2 getPosition(){
        return position.cpy();
    }

    public void setPosition(Vector2 newPosition){
        this.position = newPosition.cpy();
    }

    public float getWidth(){
        return width;
    }

    public void setWidth(float width){
        if(width <= 0){
            throw new RuntimeException("Width must be positive");
        }
        this.width = width; 
    }

    public float getHeight(){
        return height;
    }

    public void setHeight(float height){
        if(height <= 0){
            throw new RuntimeException("Height must be positive");
        }
        this.height = height;
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

    public Vector2 getSize(){
        return new Vector2(width, height);
    }
}
