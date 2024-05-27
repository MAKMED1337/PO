package com.po.fuck;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public final class InvisibleWall extends GameObject {
    protected Vector2 size;

    public enum Type {
        VERTICAL,
        HORIZONTAL
    }

    InvisibleWall(Vector2 position, Vector2 size) {
        super(position);
        this.size = size;
    }

    InvisibleWall(Vector2 position, Type type, float size) {
        this(position, type == Type.VERTICAL ? new Vector2(0, size) : new Vector2(size, 0));
    }

    @Override
    public Polygon getCollision() {
        Vector2 size2 = size.cpy().scl(0.5f);
        return new Polygon(new float[] {
                position.x + size2.x, position.y + size2.y,
                position.x - size2.x, position.y + size2.y,
                position.x - size2.x, position.y - size2.y,
                position.x + size2.x, position.y - size2.y,
        });
    }

    @Override
    public void draw(CenterDrawer drawer) {
    }
}
