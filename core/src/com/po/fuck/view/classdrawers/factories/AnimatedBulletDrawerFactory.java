package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.GifDecoder;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class AnimatedBulletDrawerFactory {

    static {
        Renderer.addDrawer(LaserBeam.class, AnimatedBulletDrawerFactory.get(LaserBeam.class,GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())));
    }

    @SuppressWarnings("all")
    public static <T extends LaserBeam> ClassDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ClassDrawer<T>() {

            Animation<TextureRegion> _animation = animation;

            @Override
            public <Drawer extends CenterDrawer> void draw(Drawer centerDrawer, T object) {
                LaserBeam laserBeam = (LaserBeam) object;
                Sprite sprite = new Sprite(_animation.getKeyFrame(laserBeam.timeElapsed));
                sprite.setRotation(-laserBeam.getVelocity().angleDeg());
                centerDrawer.draw(sprite, laserBeam.getPosition());
            }
        };
    }
    
}
