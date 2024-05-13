package com.po.fuck;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.Movement;
import com.po.fuck.weapons.Weapon;

public class Entity extends GameObject {
    {
        FUCK.initializer.init(this);
    }

    protected Movement movement = null;
    protected Weapon weapon = null;

    protected int health_points;
    protected boolean immortal = false;

    public Entity(Vector2 position) {
        super(position);
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
            dispose();

        return true;
    }

    @Override
    public void dispose() {
        FUCK.initializer.dispose(weapon);
        super.dispose();
    }
}
