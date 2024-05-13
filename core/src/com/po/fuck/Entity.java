package com.po.fuck;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;

public class Entity implements Drawable {

    {
        FUCK.initializer.init(this);
    }
    
    public final Vector2 position = new Vector2();
    protected final Sprite sprite;

    public float health_points = 0;

    public int speed = Constants.DEFAULT_SPEED;

    Entity(Sprite sprite){
		this.sprite = sprite;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, position);
    }

    public boolean isAlive(){
        return true; // fix it afterwards
    }
    
}
