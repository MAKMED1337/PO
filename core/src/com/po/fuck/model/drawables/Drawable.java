package com.po.fuck.model.drawables;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

public interface Drawable extends BasicDrawable {

    public Vector2 getPosition();

    public GeometryData getGeometryData();
}

