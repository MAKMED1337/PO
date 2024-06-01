package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.model.weapons.AnimatedBullet;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.GifDecoder;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

public class AnimatedBulletDrawerFactory {

    static {
        Renderer.addDrawer(LaserBeam.class, AnimatedBulletDrawerFactory.get(LaserBeam.class,GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())));
    }

    public static <T extends AnimatedBullet> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ObjectDrawer<T>() {

            @Override
            public void draw(CenterDrawer drawer, T object) {
                Sprite sprite = new Sprite(animation.getKeyFrame(object.getTimeElapsed()));
                sprite.setRotation(-object.getVelocity().angleDeg());
                drawer.draw(sprite, object.getPosition());
            }
        };
    }
    
}
