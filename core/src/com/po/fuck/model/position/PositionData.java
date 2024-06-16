package com.po.fuck.model.position;

import com.badlogic.gdx.math.Vector2;

import java.awt.dnd.DropTarget;

public class PositionData {
    protected Vector2 position;
    protected float rotation;
    public PositionData() {
        this.position = new Vector2();
    }
    public PositionData(Vector2 position, float rotation) {
        this.position = new Vector2(position);
        this.rotation = rotation;
    }
    public PositionData (PositionData positionData) {
        this.position = positionData.position.cpy();
        this.rotation = positionData.rotation;
    }

}
