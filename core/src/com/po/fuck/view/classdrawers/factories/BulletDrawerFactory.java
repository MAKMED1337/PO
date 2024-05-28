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

    public static <T extends Bullet> ClassDrawer<T> get(Class<T> clz, Sprite other_sprite){
        return new ClassDrawer<T>() {
            Sprite sprite = new Sprite(other_sprite);

            @Override
            public void draw(CenterDrawer centerDrawer, T object) {
                Bullet bullet = (Bullet) object;
                Vector2 position = bullet.getPosition();
                sprite.setRotation(-bullet.getVelocity().angleDeg());
                centerDrawer.draw(sprite, position);
            }
        };
    }
    
}
