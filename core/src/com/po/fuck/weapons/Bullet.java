package com.po.fuck.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.CenterDrawer;
import com.po.fuck.FUCK;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;

public abstract class Bullet implements Drawable, Updatable {
    protected Sprite sprite;
    protected Vector2 position;
    protected Vector2 velocity;

    {
        FUCK.initializer.init(this);
    }

    public Vector2 getSize() {
        return new Vector2(sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void draw(CenterDrawer drawer) {
        sprite.setRotation(-velocity.angleDeg());
        drawer.draw(sprite, position);
    }

    @Override
    public void update(float delta) {
        position.mulAdd(velocity, delta);
    }
}
