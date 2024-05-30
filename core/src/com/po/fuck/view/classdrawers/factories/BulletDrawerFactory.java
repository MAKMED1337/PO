package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.weapons.Bullet;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class BulletDrawerFactory {

    static {
        Renderer.addDrawer(CosmicBullet.class, BulletDrawerFactory.get(CosmicBullet.class, new Sprite(new Texture("bullet2.png"))));
    }

    public static <T extends Bullet> ClassDrawer<T> get(Class<T> clz, Sprite sprite){
        return new ClassDrawer<T>() {
            Sprite bulletSprite = new Sprite(sprite);

            @Override
            public void draw(CenterDrawer drawer, T object) {
                Vector2 position = object.getPosition();
                bulletSprite.setRotation(-object.getVelocity().angleDeg());
                drawer.draw(bulletSprite, position);
            }
        };
    }
    
}
