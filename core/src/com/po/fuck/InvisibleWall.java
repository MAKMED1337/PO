package com.po.fuck;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collision.Collidable;

public final class InvisibleWall implements Collidable {
    protected Vector2 position, size;

    public enum Type {
        VERTICAL,
        HORIZONTAL
    }

    InvisibleWall(Vector2 position, Vector2 size) {
        this.position = position;
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
    public Vector2 getPosition() {
        return position.cpy();
    }

    @Override
    public void setPosition(Vector2 position) {
    }
}
