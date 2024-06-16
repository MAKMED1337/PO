package com.po.fuck.model.position;

import com.badlogic.gdx.math.Vector2;

public class GeometryData extends PositionData {
    protected float width;
    protected float height;

    public GeometryData(){
        super();
    }

    public GeometryData(PositionData positionData, Vector2 size){
        super(positionData);
        if(size.x <= 0 || size.y <= 0)
            throw new RuntimeException("Height and width have to be positive");
        height = size.y;
        width = size.x;
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
    public void setSize(Vector2 size) {
        width = size.x; height = size.y;
    }
    public Vector2 getSize(){
        return new Vector2(width, height);
    }
}
