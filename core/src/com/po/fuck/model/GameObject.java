package com.po.fuck.model;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.position.GeometryData;

public class GameObject implements Drawable, Collidable, Destructable {
    protected GeometryData geometryData;

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
        return GeometryMisc.createRectangle(geometryData.getPosition(), geometryData.getWidth(), 
                                            geometryData.getHeight(), geometryData.getRotationRad());
    }

    @Override
    public void destructor() {

    }

    @Override
    public GeometryData getGeometryData() {
        return new GeometryData(geometryData);
    }
}
