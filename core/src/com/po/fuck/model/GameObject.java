package com.po.fuck.model;

import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.drawables.PositionDrawable;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.position.GeometryData;

public class GameObject implements PositionDrawable, Collidable, Destructable, Updatable {
    protected GeometryData geometryData;
    protected boolean initialCollisionIgnored = true;

    GameObject(GeometryData geometryData) {
        this.geometryData = geometryData;
    }

    @Override
    public Vector2 getPosition() {
        return geometryData.getPosition();
    }

    @Override
    public void setPosition(Vector2 position) {
        geometryData.setPosition(position);
    }

    @Override
    public Polygon getCollision() {
        return GeometryMisc.createRectangle(geometryData);
    }

    @Override
    public boolean isInvisible(){
        return initialCollisionIgnored;
    }

    @Override
    public void destructor() {

    }

    @Override
    public GeometryData getGeometryData() {
        return new GeometryData(geometryData);
    }

    @Override
    public void update(float delta){
        System.out.println(this.getClass().getName() + " update, initialCollisionIgnored: " + initialCollisionIgnored);
        if(initialCollisionIgnored){
            initialCollisionIgnored = false;
            List<Collidable> collides = All.collidableCollection.collidesWithInvisible(getCollision());

            if(collides.size() > 1 || !collides.get(0).equals(this))
                initialCollisionIgnored = true;
        }
    }
}
