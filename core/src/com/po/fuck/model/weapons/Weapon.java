package com.po.fuck.model.weapons;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.view.Drawable;

public abstract class Weapon implements Drawable {
    protected final Entity owner;
    protected Sprite sprite;
    protected Vector2 aiming = new Vector2();

    @Override
    public int get_z() {
        return 1;
    }

    Weapon(Entity owner) {
        this.owner = owner;
    }

    @Override
    public ArrayList<Sprite> getSpriteList(){
        return new ArrayList<Sprite>(){{
            add(sprite);
        }};
    }

    public Vector2 getAimPosition(){
        return aiming.cpy();
    }

    public void aim(Vector2 position) {
        aiming = position.cpy();
    }

    public abstract boolean attack();

    public Vector2 getDirection() {
        if (aiming == null)
            return new Vector2();
        return aiming.cpy().sub(owner.position);
    }
}
