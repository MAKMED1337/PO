package com.po.fuck;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collision.AABB;
import com.po.fuck.collision.Collidable;
import com.po.fuck.updates.Drawable;

public class GameObject implements Drawable, Collidable {
    public Vector2 position;
    protected Sprite sprite;

    {
        FUCK.initializer.init(this);
    }

    GameObject(Vector2 position) {
        this.position = position;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, position);
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
    public AABB getCollision() {
        Vector2 size = new Vector2(sprite.getWidth(), sprite.getHeight());
        return new AABB(position.cpy().mulAdd(size, -0.5f), position.cpy().mulAdd(size, 0.5f));
    }

    public void dispose() {
        FUCK.initializer.dispose(this);
    }
}
