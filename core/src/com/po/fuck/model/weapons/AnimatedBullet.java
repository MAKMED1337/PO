package com.po.fuck.model.weapons;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedBullet extends Bullet {
    protected static final Map<Class<?>,Animation<TextureRegion>> animationMap = new HashMap<>();

    protected final float LIVE_TIME;
    protected float timeElapsed = 0;

    protected AnimatedBullet(float live_time){
        LIVE_TIME = live_time;
    }
    
    protected static <T> boolean addAnimation(Class<T> cls, Animation<TextureRegion> animation){
        if(animationMap.containsKey(cls))
            return false;
        animationMap.put(cls, animation);
        return true;
    }

    protected static <T> Animation<TextureRegion> getAnimation(Class<T> cls){
        return animationMap.get(cls);
    }

    public float getTimeElapsed() {
        return timeElapsed;
    }
}
