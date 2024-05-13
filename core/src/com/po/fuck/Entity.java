package com.po.fuck;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collision.AABB;
import com.po.fuck.collision.Collidable;
import com.po.fuck.updates.Drawable;

public class Entity implements Drawable, Collidable {
    {
        FUCK.initializer.init(this);
    }

    public Vector2 position = new Vector2();
    protected final Sprite sprite;

    public int health_points;
    public boolean immortal = false;

    public int speed = Constants.DEFAULT_SPEED;

    Entity(Sprite sprite){
		this.sprite = sprite;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, position);
    }

    public boolean isAlive(){
        return immortal || health_points > 0;
    }

    public boolean takeDamage(int damage){
        if (immortal)
            return false;

        health_points = Math.max(0, health_points - damage);
        if (health_points == 0)
            FUCK.initializer.dispose(this);

        return true;
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
}
