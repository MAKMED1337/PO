package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.weapons.Bullet;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.GifDecoder;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

import static com.po.fuck.model.constants.LayeringConstants.WEAPON;
import static com.po.fuck.view.classdrawers.Misc.getAnimation;

public class BulletDrawerFactory {
    static {
        Renderer.addDrawer(CosmicBullet.class,
                BulletDrawerFactory.get(CosmicBullet.class, getAnimation("bullet2.png")));
        Renderer.addDrawer(LaserBeam.class, BulletDrawerFactory.get(LaserBeam.class,
                GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read())));
    }

    public static <T extends Bullet> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation) {
        return new ObjectDrawer<T>() {
            @Override
            public int getZ() {
                return WEAPON;
            }

            @Override
            public void draw(CenterDrawer drawer, T object) {
                Vector2 position = object.getPosition();
                Sprite bulletSprite = new Sprite(animation.getKeyFrame(object.getElapsedTime()));
                bulletSprite.setRotation(-object.getVelocity().angleDeg());
                drawer.draw(bulletSprite, position);
            }
        };
    }
}
