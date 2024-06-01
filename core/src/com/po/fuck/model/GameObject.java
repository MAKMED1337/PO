package com.po.fuck.model;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.lifetime.Destructable;

public class GameObject implements Drawable, Collidable, Destructable, Updatable {
    public Vector2 position;
    protected float width;
    protected float height;
    protected float rotation;
    protected float elapsedTime;

    GameObject(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getPosition() {
        return position.cpy();
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Polygon getCollision() {
        return GeometryMisc.createRectangle(position, width, height, rotation);
    }

    @Override
    public void destructor() {

    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;
    }

    public float getElapsedTime(){
        return elapsedTime;
    }
}
