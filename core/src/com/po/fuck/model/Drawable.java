package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

public interface Drawable {
    default int get_z() {
        return 0;
    }
    public Vector2 getPosition();
    public GeometryData getGeometryData();
}

