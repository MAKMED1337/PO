package com.po.fuck;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collision.Collidable;
import com.po.fuck.updates.Drawable;
import com.po.fuck.lifetime.Destructable;

public class GameObject implements Drawable, Collidable, Destructable {
    public Vector2 position;
    protected Sprite sprite;

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
    public Polygon getCollision() {
        return GeometryMisc.createRectangle(position, sprite);
    }

    @Override
    public void destructor() {
    }
}
