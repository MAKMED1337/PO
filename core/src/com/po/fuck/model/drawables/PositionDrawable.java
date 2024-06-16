package com.po.fuck.model.drawables;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

public interface PositionDrawable extends Drawable {

    default public Vector2 getPosition() {
        return getGeometryData().getPosition();
    }

    public GeometryData getGeometryData();
}
